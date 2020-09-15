package Modelo;

import java.util.ArrayList;

public class Fragmentacion {
	
	public ArrayList<Datagrama> calcularLongitudFragmento(String tamañoDatagrama, String mtuRed) {
		ArrayList<Datagrama> datagramas = new ArrayList<>();
		int tamDatagrama = Integer.parseInt(tamañoDatagrama);
		int mtu = Integer.parseInt(mtuRed);
		
		int resta = mtu - tamDatagrama;
		
		if(resta < 0) {
			return null;
		}else {
			String flags = "010";
			String offsetBinario = "0000000000000";
			String offsetDecimal = binarioADecimal(offsetBinario) + "";
			String bits16 = flags + offsetBinario;
			String digitosHexadecimales = binarioAHexadecimal(bits16);
			Datagrama datagrama = new Datagrama(tamañoDatagrama, flags, offsetBinario, offsetDecimal, digitosHexadecimales);
			
			datagramas.add(datagrama);
			return datagramas;
		}
	}
	
	public int binarioADecimal(long binario) {
		int decimal = 0;
		int posicion = 0;
		for (int x = String.valueOf(binario).length() - 1; x >= 0; x--) {
			short digito = 1;
			if (String.valueOf(binario).charAt(x) == '0') {
				digito = 0;
			}
			double multiplicador = Math.pow(2, posicion);
			decimal += digito * multiplicador;
			posicion++;
		}
		return decimal;
	}
	
	public String binarioAHexadecimal(String numero) {
		long binario = Long.parseLong(numero);
		String hexadecimal = "";
		String digitosHexa = "0123456789ABCDEF";

		while (binario > 0) {
			hexadecimal = digitosHexa.charAt((int) binarioADecimal(binario % 10000)) + hexadecimal;
			binario = binario / 10000;
		}

		return hexadecimal;
	}
	
	public int binarioADecimal(String binario) {
		int decimal = 0;
		int posicion = 0;
		for (int x = binario.length() - 1; x >= 0; x--) {
			short digito = 1;
			if (binario.charAt(x) == '0') {
				digito = 0;
			}
			double multiplicador = Math.pow(2, posicion);
			decimal += digito * multiplicador;
			posicion++;
		}
		return decimal;
	}
}
