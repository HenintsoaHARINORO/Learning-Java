
 class TestTax {
      public static void main(String [] args) {
    	  Tax t= new Tax(); // creating an instance
    	  
    	  // assigning the values to class members
    	  t.grossIncome= 5000;
    	  t.dependents= 2;
    	  t.state= "NJ";
    	  
    	  
    	  
    	  double yourTax= t.calcTax(); // calculating tax
    	  
    	  System.out.println(" Your tax is "+ yourTax);
      }
}
