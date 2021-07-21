package in28minutes.testing.business;

public class BusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public  int calculated(int[] data){
        int sum = 0;
        for(int value: data){
            sum += value;
        }
        return sum;
    }

    // unit test this method
    public int calculatedSomeDataService() {

        int sum = 0;
        int data[] = someDataService.retrieveAllData();
        for(int value: data){
            sum += value;
        }
        return sum;
    }
}
