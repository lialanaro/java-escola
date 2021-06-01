/**
 * 
 */
package util;

/**
 * Classe responsavel por validar os dados inputados pelo usuário
 * @author Nathalia Lanaro
 * @since 23/02/2021
 */
public class Valida {
	//verificando se o numero digitado é nulo e/ou vazio
	public static boolean isEmptyOrNull(String string) {
		return (string == null || string.trim().equals(""));
		
	}
	//verificando se o valor é 0
	public static boolean isIntZero(int args) {
		return (args == 0);
	}
	//verificando se o valor é 0
	public static boolean isDoubleZero(double args) {
		return (args == 0);
	}

	
}
