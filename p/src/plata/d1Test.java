package plata;

import junit.framework.TestCase;
public class d1Test extends TestCase {
public void test() throws Exception {
		try{
			plata sc = new plata();
		    sc.arrTf[0].setText("35.4");//cold water
            sc.arrTf[1].setText("32.25");//hot water
            sc.arrTf[2].setText("5.38");//svet
            sc.arrTf[6].setText("400");//v potrachennogo hot water
            sc.arrTf[7].setText("500");//v potrachennogo cold water
            sc.arrTf[8].setText("400");//v potrachennogo svet
            sc.kvartira();
        	assertEquals("17700,00", sc.arrTf[12].getText());//Cena na cold water
        	assertEquals("12900,00", sc.arrTf[13].getText());//Cena na hot water
        	assertEquals("2152,00", sc.arrTf[15].getText());//Cena na svet
        	assertEquals(" ", sc.arrTf[14].getText());//Cena na gas
        	assertEquals(" ", sc.arrTf[16].getText());//Cena na kommunalnye uslugy 	
	}catch(Exception e){
		fail("Проверьте правильность входных занчений");
		}}}
