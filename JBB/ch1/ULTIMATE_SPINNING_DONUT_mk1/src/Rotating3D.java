import java.util.Arrays;

public class Rotating3D {

    static final int screen_size = 40;
    static final double theta_spacing = 0.07;
    static final double phi_spacing = 0.02;
    static final String illumination = ".,-~:;=!*#$@";

    static double A = 1;
    static double B = 1;
    static double R1 = 1;
    static double R2 = 2;
    static double K2 = 5;
    static double K1 = screen_size * K2 * 3 / (8 * (R1 + R2));

    static double[] theta = new double[(int) (2 * Math.PI / theta_spacing)];
    static double[] phi = new double[(int) (2 * Math.PI / phi_spacing)];
    static double[] cos_phi = new double[phi.length];
    static double[] sin_phi = new double[phi.length];
    static double[] cos_theta = new double[theta.length];
    static double[] sin_theta = new double[theta.length];

    static double[] circle_x = new double[theta.length];
    static double[] circle_y = new double[theta.length];

    static {
        for (int i = 0; i < theta.length; i++) {
            theta[i] = i * theta_spacing;
            cos_theta[i] = Math.cos(theta[i]);
            sin_theta[i] = Math.sin(theta[i]);
        }
        for (int i = 0; i < phi.length; i++) {
            phi[i] = i * phi_spacing;
            cos_phi[i] = Math.cos(phi[i]);
            sin_phi[i] = Math.sin(phi[i]);
        }
        for (int i = 0; i < theta.length; i++) {
            circle_x[i] = R2 + R1 * cos_theta[i];
            circle_y[i] = R1 * sin_theta[i];
        }
    }

    static String[][] renderFrame(double A, double B) {
        double cos_A = Math.cos(A);
        double sin_A = Math.sin(A);
        double cos_B = Math.cos(B);
        double sin_B = Math.sin(B);

        String[][] output = new String[screen_size][screen_size];
        for (int i = 0; i < screen_size; i++) {
            Arrays.fill(output[i], " ");
        }

        double[][] zbuffer = new double[screen_size][screen_size];

        double[][] x = new double[phi.length][theta.length];
        double[][] y = new double[phi.length][theta.length];
        double[][] z = new double[phi.length][theta.length];
        double[][] ooz = new double[phi.length][theta.length];

        for (int i = 0; i < phi.length; i++) {
            for (int j = 0; j < theta.length; j++) {
                x[i][j] = (cos_B * cos_phi[i] + sin_A * sin_B * sin_phi[i]) * circle_x[j] - circle_y[j] * cos_A * sin_B;
                y[i][j] = (sin_B * cos_phi[i] - sin_A * cos_B * sin_phi[i]) * circle_x[j] + circle_y[j] * cos_A * cos_B;
                z[i][j] = (K2 + cos_A * sin_phi[i] * circle_x[j]) + circle_y[j] * sin_A;
                ooz[i][j] = 1.0 / z[i][j];
            }
        }

        double[][] xp = new double[phi.length][theta.length];
        double[][] yp = new double[phi.length][theta.length];
        for (int i = 0; i < phi.length; i++) {
            for (int j = 0; j < theta.length; j++) {
                xp[i][j] = (screen_size / 2 + K1 * ooz[i][j] * x[i][j]);
                yp[i][j] = (screen_size / 2 - K1 * ooz[i][j] * y[i][j]);
            }
        }

        int[][] L = new int[phi.length][theta.length];
        for (int i = 0; i < phi.length; i++) {
            for (int j = 0; j < theta.length; j++) {
                double L1 = ((cos_phi[i] * cos_theta[j] * sin_B) - cos_A * sin_phi[i] * cos_theta[j]) - sin_A * sin_theta[j];
                double L2 = cos_B * (cos_A * sin_theta[j] - sin_phi[i] * cos_theta[j] * sin_A);
                L[i][j] = (int) Math.round((L1 + L2) * 8);
            }
        }

        String[][] chars = new String[phi.length][theta.length];
        for (int i = 0; i < phi.length; i++) {
            for (int j = 0; j < theta.length; j++) {
                if (L[i][j] >= 0 && L[i][j] < illumination.length()) {
                    chars[i][j] = String.valueOf(illumination.charAt(L[i][j]));
                } else {
                    chars[i][j] = " ";
                }
            }
        }

        for (int i = 0; i < 90; i++) {
            for (int j = 0; j < theta.length; j++) {
                for (int k = 0; k < phi.length; k++) {
                    boolean mask = L[k][j] >= 0 && ooz[k][j] > zbuffer[(int) xp[k][j]][(int) yp[k][j]];
                    if (mask) {
                        zbuffer[(int) xp[k][j]][(int) yp[k][j]] = ooz[k][j];
                        output[(int) xp[k][j]][(int) yp[k][j]] = chars[k][j];
                    }
                }
            }
        }

        return output;
    }

    static void pprint(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.join(" ", array[i]));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < screen_size * screen_size; i++) {
            A += theta_spacing;
            B += phi_spacing;
            System.out.print("\033[H");
            System.out.flush();
            pprint(renderFrame(A, B));
            Thread.sleep(50);
        }
    }
}
