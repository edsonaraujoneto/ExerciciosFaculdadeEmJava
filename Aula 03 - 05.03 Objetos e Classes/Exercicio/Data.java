public class Data {
    private String dia,mes,ano;
    
    public Data (String dia, String mes, String ano) {
        if (Float.parseFloat(dia)>31 || Float.parseFloat(dia) <=0 || Float.parseFloat(mes) > 12 || Float.parseFloat(mes) <= 0 || Float.parseFloat(ano) < -0) {
            this.dia = "01";
            this.mes = "01";
            this.ano = "0001"; 
        }
        else { 
           this.dia = dia;
           this.mes = mes;
           this.ano = ano;
       }
    }
    
    public int comparar (Data outra) { 
        if (outra.getData().equals(this.getData()))  {
            return 0;
        } else if (Float.parseFloat(outra.getData()) < Float.parseFloat(this.getData())) {
            return 1;
            } 
        return -1;
    }
    
    public boolean isBissexto () {
        if (Float.parseFloat(ano)%4==0) {
            return true;
        }
        else {
            return false;
        }
    }  
    
    public Data clonar () { 
        return this;
    }
    
    public String getDia () { 
    return dia;
    }
    
    public String getMes () { 
    return mes;
    }
    
    public String getAno () { 
    return ano;
    }   
    
    public String getMesExtenso () { 
        switch (Integer.parseInt(mes)) {
            case 1: return "Janeiro";
            case 2: return "Fevereiro";  
            case 3: return "Março";
            case 4: return "Abril";
            case 5: return "Maio";        
            case 6: return "Junho";    
            case 7: return "Julho";   
            case 8: return "Agosto";
            case 9: return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";      
            case 12: return "Dezembro";
        }
        return "Digite um mês válido!";
    }
        
    public String getData () {
        return dia+mes+ano;
    }
}
