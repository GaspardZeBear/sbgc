package gzb.sbgc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibo {
	private static final Logger logger = LoggerFactory.getLogger(Fibo.class);
	int result=0;
	
	public Fibo(int c, int n) {
	  logger.info(String.format("%d %d",c,n));
	  fibo(c,n);
	  }
	
	public void fibo(int c,int n) {

		for(int l=0;l<c;++l) {
		  int n1=0,n2=1; 
	      for(int i=2;i<=n;++i) {    
		    result=n1+n2;    
		    n1=n2;    
		    n2=result;    
		   } 
		}
	}
	
	public int getResult() {
		return(result);
	}

}