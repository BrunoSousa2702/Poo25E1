package Poo25E1;
import java.util.Date;

public class FrequenciaRealizada {
	private ModeloODS modulo;
    private int nota;
    private Date data;
    
    public FrequenciaRealizada(ModeloODS modulo, int nota, Date data) {
        this.modulo = modulo;
        this.nota = nota;
        this.data = data;
    }
     
    public ModeloODS getModulo() {
        return modulo;
    }
    public int getNota() {
        return nota;
    }
    public Date getData() {
        return data;
    }

}
