class Vehicl {
    int passengers; // 승객 수
    int fuelcap;    // 연료 용량 (갤런 단위)
    int mpg;        // 연료 소비량 (마일/갤런)

    // 주행 가능 거리 계산 메서드 추가
    int range() {
        return fuelcap * mpg; // 주행 가능 거리 = 연료 용량 × 연비
    }// c++은 this로 접근하는 방법도있음. 자바는 그럴필요 없음

    double fuelneeded(int miles) {
        return (double) miles / mpg;

        //static_cast<double>(miles) / mpg  : c++ 의 경우
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        // Vehicle 객체 생성
        Vehicle minivan = new Vehicle();

        // 객체에 데이터 설정
        minivan.passengers = 7;         // 승객 수 설정
        minivan.fuelcap = 16;           // 연료 용량 설정
        minivan.mpg = 21;               // 연료 소비량 설정

        // 객체 정보 출력
        System.out.println("Minivan can carry " + minivan.passengers + " passengers.");
        System.out.println("Fuel capacity is " + minivan.fuelcap + " gallons.");
        System.out.println("Fuel consumption is " + minivan.mpg + " miles per gallon.");

        // 주행 가능 거리 출력
        int range = minivan.range(); // range() 메서드 호출
        System.out.println("Minivan's range is " + range + " miles.");
    }

//    #### 자바의 가비지 컬렉션#########
//    자동 메모리 관리
//    자바는 **가비지 컬렉션(Garbage Collection)**을 통해 사용하지 않는 객체를 자동으로 제거합니다.
//    가비지 컬렉션의 작동 원리:
//    더 이상 참조되지 않는 객체를 탐지.
//    해당 객체가 차지하던 메모리를 회수하여 재사용 가능하게 만듦.

//    Vehicle car1 = new Vehicle(4, 10, 25);
//    car1 = null; // car1이 더 이상 객체를 참조하지 않음


//    가비지 컬렉션은 다음과 같은 상황에서 메모리를 해제합니다:
//
//    객체 참조 제거 (null 할당).
//    변수의 스코프 종료.
//    순환 참조가 발생했지만 외부에서 접근 불가.
//    약한 참조(WeakReference) 사용.
//    쓰레드 종료 및 배열 참조 제거.
//
//    두 객체가 서로를 참조하더라도, 외부에서 접근할 수 없는 경우 가비지 컬렉션이 이를 탐지하고 메모리를 해제합니다.
//    자바의 가비지 컬렉션은 **참조 카운팅(Reference Counting)**이 아니라 **루트 접근성(Root Reachability)**을 기준으로 동작
//

//
//    Wrapper 클래스 사용
//    자바는 원시 타입을 객체로 다룰 수 있도록 래퍼 클래스(Wrapper Class)를 제공합니다
    // Integer x = Integer.valueOf(10); // 객체로 포장
    //int y = x.intValue();           // 원시 타입으로 변환

}