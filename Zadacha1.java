import java.util.Arrays;

	public class Zadacha1 {
		public static void main(String[] args) {

			char[][] key = { 
					{ 'A', 'W', 'F', 'S', 'K' }, 
					{ 'X', 'E', 'R', 'J', 'O' }, 
					{ 'D', 'Q', 'I', 'N', 'V' },
					{ 'P', 'H', 'M', 'U', 'B' }, 
					{ 'G', 'L', 'T', 'C', 'Y' },

			};

			String text = "AEIU";
			String textToEncrypt = new String();
			int rowLetter1 = 0, colLetter1 = 0, rowLetter2 = 0, colLetter2 = 0, index = 0;
			boolean secondLetter = false, done = false;
			if (text.contains("z") || text.contains("Z")) {
				System.out.println("ERROR");
			} else {

				if (text.length() % 2 != 0) {
					textToEncrypt = text.concat("P").toUpperCase();
				} else {
					textToEncrypt = text.toUpperCase();
				}

				char[] encryptedText = textToEncrypt.toCharArray();

				while (index < text.length()) {

					for (int row = 0; row < key.length; row++) {
						for (int col = 0; col < key[0].length; col++) {
							if (encryptedText[index] == key[row][col] && secondLetter == false) {
								rowLetter1 = row;
								colLetter1 = col;
								System.out.println(" RL1 " + row + " CL1 " + col);
								index++;
								secondLetter = true;
								row = 0;
								col = 0;
								break;
							}
							if (encryptedText[index] == key[row][col] && secondLetter == true) {
								rowLetter2 = row;
								colLetter2 = col;
								System.out.println(" RL2 " + row + " CL2 " + col);
								index++;
								done = true;
								break;
							}

						}
						if (done == true)
							break;
					}
					if (rowLetter1 != rowLetter2 && colLetter1 != colLetter2 ) {
						encryptedText[index - 2] = key[rowLetter1][colLetter2];
						encryptedText[index - 1] = key[rowLetter2][colLetter1];
					}
					
					
					secondLetter = false;
					done = false;
					System.out.println("Original text: " + text.toUpperCase());	
					System.out.println("Encrypted text: " + Arrays.toString(encryptedText));	
					
					
					
					
					
//	Doesnt work needs to be checked				// Same Row
//					if (rowLetter1 == rowLetter2) {
//						// If one of them goes out of the array length.
//						if (colLetter1 + 1 > key[0].length - 1 || colLetter2 > key[0].length - 1) {
//							// If the first is out, and they are not the same letter
//							// the 2nd +1 must be within the limits of the array.
//							if (colLetter1 + 1 > key[0].length - 1) {
//								encryptedText[index - 1] = key[rowLetter2][colLetter2 + 1];
//								encryptedText[index - 2] = key[rowLetter1][0];
//							}
//							// The same as the previous comment but with the second.
//							if (colLetter2 + 1 > key[0].length - 1) {
//
//								encryptedText[index - 1] = key[rowLetter2][0];
//								encryptedText[index - 2] = key[rowLetter1][colLetter1 + 1];
//							}
//							// Both are the same letter.
//							if (colLetter1 == colLetter2) {
//								encryptedText[index - 1] = key[rowLetter2][0];
//								encryptedText[index - 2] = key[rowLetter1][0];
//							}
//
//						}else{
//							System.out.println(encryptedText[index - 1]);
//							encryptedText[index - 1] = key[rowLetter2+1][colLetter2];
//							System.out.println(encryptedText[index - 1]);
//							encryptedText[index - 2] = key[rowLetter1+1][colLetter1];
//						}
//
//					}
//
//					// Same Col
//					if (colLetter1 == colLetter2) {
//
//						// If one of them goes out of the array length.
//						if (rowLetter1 + 1 > key[0].length - 1 || rowLetter2 > key[0].length - 1) {
//							// If the first is out, and they are not the same letter
//							// the 2nd +1 must be within the limits of the array.
//							if (rowLetter1 + 1 > key[0].length - 1) {
//								encryptedText[index - 1] = key[rowLetter2 + 1][colLetter2];
//								encryptedText[index - 2] = key[0][colLetter1];
//							}
//							// The same as the previous comment but with the second.
//							if (rowLetter2 + 1 > key[0].length - 1) {
//
//								encryptedText[index - 1] = key[0][colLetter2];
//								encryptedText[index - 2] = key[rowLetter1+1][colLetter1];
//							}
//							// Both are the same letter.
//							if (rowLetter1 == rowLetter2) {
//								
//								encryptedText[index - 1] = key[0][colLetter2];
//								
//								encryptedText[index - 2] = key[0][colLetter1];
//							}
//
//						} else{
//							System.out.println(encryptedText[index - 1]);
//							encryptedText[index - 1] = key[rowLetter2+1][colLetter2];
//							System.out.println(encryptedText[index - 1]);
//							encryptedText[index - 2] = key[rowLetter1+1][colLetter1];
//							
//						}
//					}
//					
//					secondLetter = false;
//					done = false;	
//					index++;
//					
//				}
					
					
					
					
					
					
					
				}
				
			}
		}
	}
}
