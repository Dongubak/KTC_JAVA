class Vehicle {
    int passengers; // 승객 수
    int fuelcap;    // 연료 용량 (갤런 단위)
    int mpg;        // 연료 소비량 (마일/갤런)

    // 주행 가능 거리 반환
    int range() {
        return mpg * fuelcap;
    }

    // 주어진 거리에서 필요한 연료량 계산
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }
}

public class CompFuel {
    public static void main(String args[]) {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        double gallons; // 필요한 연료량 저장
        int dist = 252; // 주행 거리 (마일)

        // minivan 데이터 설정
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // sportscar 데이터 설정
        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        // minivan에서 필요한 연료 계산 및 출력
        gallons = minivan.fuelneeded(dist);
        System.out.println("To go " + dist + " miles minivan needs " +
                gallons + " gallons of fuel.");

        // sportscar에서 필요한 연료 계산 및 출력
        gallons = sportscar.fuelneeded(dist);
        System.out.println("To go " + dist + " miles sportscar needs " +
                gallons + " gallons of fuel.");
    }
}
