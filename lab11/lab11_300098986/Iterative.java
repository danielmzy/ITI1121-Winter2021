public class Iterative {

	public static BitList complement( BitList in ) {

		Iterator that = in.iterator(); 
        String temporary = ""; 

        while (that.hasNext()) { 
            int presentState = that.next(); 

            if (presentState == BitList.ONE) { 
                temporary += BitList.ZERO; 
            } else { 
                temporary += BitList.ONE; 
            }
        }

        return new BitList(new StringBuilder(temporary).reverse().toString()); 
	}

	public static BitList or( BitList a, BitList b ) {

        if (a.toString().length() != b.toString().length()) { 
            throw new IllegalArgumentException(); 
        }

        if (a.toString().equals(String.valueOf(BitList.ZERO)) || b.toString().equals(String.valueOf(BitList.ZERO))) { 
            throw new IllegalArgumentException(); 
        }

        Iterator iterator_A = a.iterator(); 
        Iterator iterator_B = b.iterator(); 
        String temporary = "";

        while(iterator_A.hasNext()) { 
            int present_A = iterator_A.next(); 
            int present_B = iterator_B.next(); 


            if (present_A == BitList.ZERO && present_B == BitList.ZERO) { 
                temporary += BitList.ZERO; 
            } else { 
                temporary += BitList.ONE; 
            }
        }  

        return new BitList(new StringBuilder(temporary).reverse().toString());
        
	}

	public static BitList and( BitList a, BitList b ) {

        if (a.toString().length() != b.toString().length()) { 
            throw new IllegalArgumentException(); 
        }

        if (a.toString().equals(String.valueOf(BitList.ZERO)) || b.toString().equals(String.valueOf(BitList.ZERO))) { 
            throw new IllegalArgumentException(); 
        }

        Iterator iterator_A = a.iterator(); 
        Iterator iterator_B = b.iterator(); 
        String temporary = "";

        while(iterator_A.hasNext()) { 
            int present_A = iterator_A.next(); 
            int present_B = iterator_B.next(); 

            if(present_A == BitList.ONE && present_B == BitList.ONE) { 
                temporary += BitList.ONE; 
            } else { 
                temporary += BitList.ZERO; 
            }
        }

        return new BitList(new StringBuilder(temporary).reverse().toString()); 
	}

	public static BitList xor( BitList a, BitList b ) {

        if (a.toString().length() != b.toString().length()) { 
            throw new IllegalArgumentException(); 
        }

        if (a.toString().equals(String.valueOf(BitList.ZERO)) || b.toString().equals(String.valueOf(BitList.ZERO))) { 
            throw new IllegalArgumentException(); 
        }

        Iterator iterator_A = a.iterator(); 
        Iterator iterator_B = b.iterator(); 
        String temporary = "";

        while(iterator_A.hasNext()) { 
            int present_A = iterator_A.next(); 
            int present_B = iterator_B.next();

            if (present_A == BitList.ONE && present_B == BitList.ONE) { 
                temporary += BitList.ZERO; 
            } else if (present_A == BitList.ZERO && present_B == BitList.ZERO) { 
                temporary += BitList.ZERO; 
            } else { 
                temporary += BitList.ONE; 
            } 
        }

        return new BitList(new StringBuilder(temporary).reverse().toString());

		
	}
}