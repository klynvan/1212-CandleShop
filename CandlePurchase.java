/**
 * ITSC 1212 CandlePurchase class
 * Created by Adam Whaley
 *
 * 
 *
 */


public class CandlePurchase {
  
  //Declare fields for CandlePurchase
  private int numType1;
  private int numType2;
  private int numType3;
  private final int PURCHASE_THRESHOLD = 7;
  private final int DISCOUNT_THRESHOLD = 7;
  Candle type1 = new Candle(1, 2.5, (5*60),.01);    // Create a Candle object for a Type 1 candle
  Candle type2 = new Candle(2, 3.75, (7*60), .03);   // Create a Candle object for a Type 2 candle
  Candle type3 = new Candle(3, 5.99, (12*60), .05);  // Create a Candle object for a Type 3 candle
  
  public CandlePurchase(int numType1, int numType2, int numType3) {
    //TODO
    //setting varibles
    this.numType1=numType1;
    this.numType2=numType2;
    this.numType3=numType3;
  }
  
  public double getSubTotal() {
    //TODO
    double costType1 = numType1 * type1.getCost();//getting cost of the ammount of type 1 candles
    double costType2 = numType2 * type2.getCost();//getting cost of the ammount of type 2 candles
    double costType3 = numType3 * type3.getCost();//getting cost of the ammount of type 3 candles
    //Will apply discount to candle 1 if more than 7
    if(numType1>=DISCOUNT_THRESHOLD){
      costType1 = costType1*0.95;
    }
    
    //Will apply discount to candle 2 if more than 7
    if(numType2>=DISCOUNT_THRESHOLD){
      costType2 = costType2*0.95;
    }
    
    //Will apply discount to candle 3 if more than 7
    if(numType3>=DISCOUNT_THRESHOLD){
      costType3 = costType3*0.95;
    }
    //calc the sub total of all candles combined
    double subTotal = (costType1 + costType2 + costType3);
    return subTotal;//give subtotal
  }
  
  public double getTotalTax() {
    //TODO
    double costType1 = numType1 * type1.getCost();//getting cost of the ammount of type 1 candles
    double costType2 = numType2 * type2.getCost();//getting cost of the ammount of type 2 candles
    double costType3 = numType3 * type3.getCost();//getting cost of the ammount of type 3 candles
    
    double taxType1 = (costType1 *this.type1.getTax());//calculates the total for candle 1 with it's tax
    double taxType2 = (costType2*this.type2.getTax());//calculates the total for candle 2 with it's tax
    double taxType3 = (costType3*this.type3.getTax());//calculates the total for candle 3 with it's tax
    double totalTax = (taxType1 + taxType2 +taxType3);//total of all the candles combined
    return totalTax;///gives total cost of all candles
    
  }
  
  public int getTotalBurnTime() {
    //TODO
    int totalBurnTime = this.type1.getTime()+this.type2.getTime()+this.type3.getTime();//calculate total burntime of the candles
    return totalBurnTime;//give total of all candles burntime
  }
  
  // method that calculates the grand total of a purchase
  // by combining the returns of getSubTotal and getTotalTax
  public double getTotal() {
    
    return getSubTotal() + getTotalTax();
    
  }
  
  public void getPurchaseBreakdown() {
    //TODO   
    System.out.println("If customer bought more than 7 of each candles were bought therefore 5% discount was applied ");
    //allows custmer to know if 5% discount is applied to candle 1
    if(numType1 > DISCOUNT_THRESHOLD){
      System.out.println("More than 7 Type 1 candles were bought therefore 5% discount was applied");
    }
    //allows custmer to know if 5% discount is applied to candle 2
    if(numType2 > DISCOUNT_THRESHOLD){
      System.out.println("More than 7 Type 2 candles were bought therefore 5% discount was applied");
    }
    //allows custmer to know if 5% discount is applied to candle 3
    if(numType3 > DISCOUNT_THRESHOLD){
      System.out.println("More than 7 Type 3 candles were bought therefore 5% discount was applied");
    }
    
    System.out.println("SubTotal = "+this.getSubTotal());//print out subtotal
    System.out.println("Total taxes = "+this.getTotalTax());//print out total of taxes
    System.out.println("Total = "+this.getTotal());//print out total
    
    System.out.println("\n"+"Number of Type 1 candle purchased:");
    //prints out the number of candle type 1 in "*"
    for(int i=0; i<numType1;i++){
      System.out.print("*");
    }
    System.out.println("\n"+"Number of Type 2 candle purchased:");
    //prints out the number of candle type 2 in "*"
    for(int i=0; i<numType2;i++){
      System.out.print("*");
    }
    System.out.println("\n"+"Number of Type 3 candle purchased:");
    //prints out the number of candle type 3 in "*"
    for(int i=0; i<numType3;i++){
      System.out.print("*");
    }
  }
  
  
}