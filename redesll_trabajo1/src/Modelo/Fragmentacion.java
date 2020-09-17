package Modelo;

import java.util.ArrayList;

public class Fragmentacion {

	public static ArrayList<Datagrama> calcularLongitudFragmento(String tamañoDatagrama, String mtuRed) {
		ArrayList<Datagrama> datagramas = new ArrayList<>();
		int tamDatagrama = Integer.parseInt(tamañoDatagrama);
		int mtu = Integer.parseInt(mtuRed);
		int numFragmentos = (tamDatagrama / mtu) + 1;
		int offset = 0;

		for (int i = 0; i < numFragmentos; i++) {
			System.out.println(i + "-----" + numFragmentos);
			if (i == numFragmentos - 1) {

				Datagrama datagrama = new Datagrama(tamDatagrama - 20 + "", "000", obtenerBinario(offset), offset + "",
						"000" + binarioAHexadecimal(obtenerBinario(offset)));
				tamDatagrama = tamDatagrama - (mtu - 20);
				datagramas.add(datagrama);

			} else {

				Datagrama datagrama = new Datagrama(mtu + "", "001", obtenerBinario(offset),
						binarioADecimal(obtenerBinario(offset)) + "", binarioAHexadecimal(obtenerBinario(offset)));
				tamDatagrama = tamDatagrama - (mtu - 20);
				offset = offset + (mtu - 20);
				datagramas.add(datagrama);

			}

		}
		return datagramas;

	}

	public static int binarioADecimal(long binario) {
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

	public static String binarioAHexadecimal(String numero) {
		long binario = Long.parseLong(numero);
		String hexadecimal = "";
		String digitosHexa = "0123456789ABCDEF";

		while (binario > 0) {
			hexadecimal = digitosHexa.charAt((int) binarioADecimal(binario % 10000)) + hexadecimal;
			binario = binario / 10000;
		}

		return hexadecimal;
	}

	public static int binarioADecimal(String binario) {
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

	public static String obtenerBinario(int decimal) {
		if (decimal <= 0) {
			return "0";
		}
		StringBuilder binario = new StringBuilder();
		while (decimal > 0) {
			short residuo = (short) (decimal % 2);
			decimal = decimal / 2;
			// Insertar el dígito al inicio de la cadena
			binario.insert(0, String.valueOf(residuo));
		}
		String binarioS = "" + binario;

		for (int i = 0; i < (13 - binario.length()); i++) {

			binarioS = "0" + binarioS;

		}
		return binarioS;
	}

}
