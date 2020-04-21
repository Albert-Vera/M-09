package Joc_TCP;

public class El_Ahorcado {

    public String generarParaula(){
        String paraules[] = {"hola", "casa", "mercat", "canço", "camio", "percussio", "sol", "basto",
                "paraula", "blanquejar","calcular","neixer","mal","avio","melo","mon","rebel","independencia",
                "llapis", "mandarina","sindria","papaia", "bola","plom","ninot"};
        int aleatoria = (int)(Math.random()*24);
        System.out.println("paraula aleatoria: " + paraules[aleatoria]);
        return paraules[aleatoria];
    }
    private char[] paraula_a_Char(String paraula){
        char[] lletras;
        lletras = new char[paraula.length()];
        for(int i = 0; i < paraula.length(); i++){
            lletras[i] = paraula.charAt(i);
        }
        return lletras;
    }
    public String respostaSiNoEncerta(String paraulaEntrant, String paraulaSecreta ){
        char [] a = paraula_a_Char(paraulaEntrant);
        char [] b = paraula_a_Char(paraulaSecreta);
        String retorno = "";
        for (int i = 0; i < paraulaSecreta.length(); i++) {
            if ( a[i] == b[i])  {
                retorno += b[i];
            }
            else retorno += "-";
        }
        return retorno;
    }
    public String comprova_Paraula(String paraula, String paraulaSecreta){
        if (paraula.equalsIgnoreCase(paraulaSecreta)) return "Correcte";
        else return "Coincidències:   ";
    }
}
