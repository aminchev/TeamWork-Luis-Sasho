import java.util.Arrays;
import java.util.Scanner;

public class Zadacha1 {

	public static char[] encryptText(char[] encryptedText, char[][] key) {
		int rowLetter1 = 0;
		int colLetter1 = 0;
		int rowLetter2 = 0;
		int colLetter2 = 0; 
		int index = 0;
		boolean secondLetter = false, done = false;

		System.out.println("Original text: " + Arrays.toString(encryptedText));

		while (index < encryptedText.length) {

			for (int row = 0; row < key.length; row++) {
				for (int col = 0; col < key[0].length; col++) {
					// Finding and saving the position of the first letter
					// in the matrix.
					if (encryptedText[index] == key[row][col] && secondLetter == false) {
						rowLetter1 = row;
						colLetter1 = col;

						index++;
						secondLetter = true;
						row = 0;
						col = 0;
					}
					// Finding and saving the position of the first letter
					// in the matrix.
					if (encryptedText[index] == key[row][col] && secondLetter == true) {
						rowLetter2 = row;
						colLetter2 = col;
						index++;
						done = true;
						break;
					}

				}
				// Once we have found the position in the matrix we stop the
				// search and start the encryptation part.
				if (done == true)
					break;
			}
			// Best case letters are in dif. rows and cols
			if (rowLetter1 != rowLetter2 && colLetter1 != colLetter2) {
				encryptedText[index - 2] = key[rowLetter1][colLetter2];
				encryptedText[index - 1] = key[rowLetter2][colLetter1];
			}

			// Same row
			if (rowLetter1 == rowLetter2) {

				if (colLetter1 + 1 > key[0].length - 1 || colLetter2 + 1 > key[0].length - 1) {
					// If the first is out, and they are not the same letter
					// the 2nd +1 must be within the limits of the array.
					if (colLetter1 + 1 > key[0].length - 1) {
						encryptedText[index - 1] = key[rowLetter2][colLetter2 + 1];
						encryptedText[index - 2] = key[rowLetter1][0];
					}
					// The same as the previous comment but with the second.
					if (colLetter2 + 1 > key[0].length - 1) {

						encryptedText[index - 1] = key[rowLetter2][0];
						encryptedText[index - 2] = key[rowLetter1][colLetter1 + 1];
					}
					// If they are in the same col.
					if (colLetter1 == colLetter2) {
						encryptedText[index - 1] = key[rowLetter2][0];
						encryptedText[index - 2] = key[rowLetter1][0];
					}
					// Best case, none of them will get out of the range of
					// the array
				} else {

					encryptedText[index - 1] = key[rowLetter2][colLetter2 + 1];
					encryptedText[index - 2] = key[rowLetter1][colLetter1 + 1];
				}

			}
			// Same row
			if (colLetter1 == colLetter2) {
				// Same process as the previous case,
				if (rowLetter1 + 1 > key[0].length - 1 || rowLetter2 + 1 > key[0].length - 1) {

					if (rowLetter1 + 1 > key[0].length - 1) {
						encryptedText[index - 1] = key[rowLetter2 + 1][colLetter2];
						encryptedText[index - 2] = key[0][colLetter1];
					}

					if (rowLetter2 + 1 > key[0].length - 1) {

						encryptedText[index - 1] = key[0][colLetter2];
						encryptedText[index - 2] = key[rowLetter1 + 1][colLetter1];
					}

					if (rowLetter1 == rowLetter2) {

						encryptedText[index - 1] = key[0][colLetter2];
						encryptedText[index - 2] = key[0][colLetter1];
					}

				} else {

					encryptedText[index - 1] = key[rowLetter2 + 1][colLetter2];
					encryptedText[index - 2] = key[rowLetter1 + 1][colLetter1];

				}
			}

			secondLetter = false;
			done = false;

		}
		System.out.println("Encrypted text: " + Arrays.toString(encryptedText));
		return encryptedText;
	}

	public static char[] decryptText(char[] decryptedText, char[][] key) {
		int rowLetter1 = 0, colLetter1 = 0, rowLetter2 = 0, colLetter2 = 0, index = 0;
		boolean secondLetter = false, done = false;

		while (index < decryptedText.length) {

			for (int row = 0; row < key.length; row++) {
				for (int col = 0; col < key[0].length; col++) {
					// Finding and saving the position of the first letter
					// in the matrix.
					if (decryptedText[index] == key[row][col] && secondLetter == false) {
						rowLetter1 = row;
						colLetter1 = col;

						index++;
						secondLetter = true;
						row = 0;
						col = 0;
					}
					// Finding and saving the position of the first letter
					// in the matrix.
					if (decryptedText[index] == key[row][col] && secondLetter == true) {
						rowLetter2 = row;
						colLetter2 = col;
						index++;
						done = true;
						break;
					}

				}
				// Once we have found the position in the matrix we stop the
				// search and start the encryptation part.
				if (done == true)
					break;
			}
			// Best case letters are in dif. rows and cols
			if (rowLetter1 != rowLetter2 && colLetter1 != colLetter2) {
				decryptedText[index - 2] = key[rowLetter1][colLetter2];
				decryptedText[index - 1] = key[rowLetter2][colLetter1];
			}

			// Same row
			if (rowLetter1 == rowLetter2) {

				if (colLetter1 - 1 < 0 || colLetter2 - 1 < 0) {
					// If the first is out, and they are not the same letter
					// the 2nd +1 must be within the limits of the array.
					if (colLetter1 - 1 < 0) {
						decryptedText[index - 1] = key[rowLetter2][colLetter2 - 1];
						decryptedText[index - 2] = key[rowLetter1][key[0].length-1];
					}
					// The same as the previous comment but with the second.
					if (colLetter2 - 1 < 0) {

						decryptedText[index - 1] = key[rowLetter2][key[0].length-1];
						decryptedText[index - 2] = key[rowLetter1][colLetter1 - 1];
					}
					// If they are in the same col.
					if (colLetter1 == colLetter2) {
						decryptedText[index - 1] = key[rowLetter2][key[0].length-1];
						decryptedText[index - 2] = key[rowLetter1][key[0].length-1];
					}
					// Best case, none of them will get out of the range of
					// the array
				} else {

					decryptedText[index - 1] = key[rowLetter2][colLetter2 - 1];
					decryptedText[index - 2] = key[rowLetter1][colLetter1 - 1];
				}

			}
			// Same row
			if (colLetter1 == colLetter2) {
				// Same process as the previous case,
				if (rowLetter1 - 1 < 0 || rowLetter2 - 1 < 0) {

					if (rowLetter1 - 1 < 0) {
						decryptedText[index - 1] = key[rowLetter2 - 1][colLetter2];
						decryptedText[index - 2] = key[key[0].length-1][colLetter1];
					}

					if (rowLetter2 - 1 < 0) {

						decryptedText[index - 1] = key[key[0].length-1][colLetter2];
						decryptedText[index - 2] = key[rowLetter1 - 1][colLetter1];
					}

					if (rowLetter1 == rowLetter2) {

						decryptedText[index - 1] = key[key[0].length-1][colLetter2];
						decryptedText[index - 2] = key[key[0].length-1][colLetter1];
					}

				} else {

					decryptedText[index - 1] = key[rowLetter2 - 1][colLetter2];
					decryptedText[index - 2] = key[rowLetter1 - 1][colLetter1];

				}
			}

			secondLetter = false;
			done = false;

		}
		System.out.println("Decrypted text: " + Arrays.toString(decryptedText));
		return decryptedText;

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] key = { { 'A', 'W', 'F', 'S', 'K' }, { 'X', 'E', 'R', 'J', 'O' }, { 'D', 'Q', 'I', 'N', 'V' },
				{ 'P', 'H', 'M', 'U', 'B' }, { 'G', 'L', 'T', 'C', 'Y' },

		};
		System.out.println("Enter a text for encrypting:");
		String text = sc.nextLine();
		//String text = "TEXTMEXT";
		String textToEncrypt = new String();

		// Z is not included in our availible letters.
		if (text.contains("z") || text.contains("Z")) {
			System.out.println("ERROR");
		} else {
			// If the text is not even, we add another char, 'p' at the end.
			if (text.length() % 2 != 0) {
				textToEncrypt = text.concat("P").toUpperCase();
			} else {
				textToEncrypt = text.toUpperCase();
			}

			char[] encryptedText = textToEncrypt.toCharArray();

			decryptText(encryptText(encryptedText, key), key);

		}
	}
}
