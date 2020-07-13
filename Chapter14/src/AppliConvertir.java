class ApplConvertir {
	int DecimalNumber;
	
	ApplConvertir(int DcNumber){
		DecimalNumber=DcNumber;
	}
	public String ToHexa(int DecimalNumber) {
		   int rem;
		   String str2="";
		   char hex[]= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		   while(DecimalNumber >0 && DecimalNumber<=65535)
		   {
			   rem=DecimalNumber%16;
			   str2=hex[rem]+str2;  //conversion in hexadecimal code
			   DecimalNumber=DecimalNumber/16;
		   }
		   return str2;
	   }
}

	
 	
    
   
   