package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		registrosArchivo("F:/tabla.txt");
		generarInformePrestamo(1000000.0,1.0,12);
	}
	
	public static void registrosArchivo(String rutaArchivo){
		
		int totalNumeroRegistros=0;
		int totalNumerosPositivos=0;
		int totalNumerosNegativos=0;

	      FileReader fr = null;
	      BufferedReader br=null;
	      try {
	    	 File archivo = new File (rutaArchivo);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null){       	 
	        	 String[] tupla=linea.split(" ");
	        	 int numeroRegistro=0;
	        	 Integer regitroInformacion=Integer.parseInt(tupla[numeroRegistro]);
	        	 while(!regitroInformacion.toString().contains("0")){
	        		 numeroRegistro++;
	        		 totalNumeroRegistros++;
	        		 if(regitroInformacion>0){
	        			 totalNumerosPositivos++;
	        		 }else{
	        			 totalNumerosNegativos++;
	        		 }
	        		 regitroInformacion=Integer.parseInt(tupla[numeroRegistro]);
	        	 }	        	 	        	 
	         }
	         
	 		System.out.println("Número Total de Registros:"+totalNumeroRegistros);
			System.out.println("Número Total de Negativos:"+totalNumerosNegativos);
			System.out.println("Número Total de Positivos:"+totalNumerosPositivos);
	            
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{   
	            if(br!=null){   
	            	br.close();     
		        }	        	 
	            if(fr!=null){
	               fr.close();     
	            }    	            
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	public static void generarInformePrestamo(Double montoIngresado, Double tasaInteres, int numeroCuotas) {
		try {
			Double interesPagar=0.0;
			Double montoAdeudado=0.0;			
			Double capitalPagar=montoIngresado/numeroCuotas;
			
			for (int i = 0; i < numeroCuotas; i++) {
				if(i==0){
					montoAdeudado=montoIngresado;
				}else{
					montoAdeudado=montoAdeudado-capitalPagar;
				}
				interesPagar=(tasaInteres/100)*montoAdeudado;
				System.out.println("**Numero de Cuota:"+(i+1));
				System.out.println("Monto Adeudado:"+montoAdeudado);
				System.out.println("Valor de la Cuota:"+(capitalPagar+interesPagar));				
				System.out.println("Interes A Pagar:"+interesPagar);
				System.out.println("Capital A Pagar:"+capitalPagar+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
