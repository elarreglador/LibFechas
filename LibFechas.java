import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LibFechas {

    public static void main(String[] args){
        LibFechas fecha = new LibFechas(20240107);
        System.out.println(fecha.getDiaSemana() + " " + fecha.numDia + "/" + fecha.numMes + "/" + fecha.numYear);
    }

    int fechaBase; //dia en formato YYYYMMDD

    String diaSemana;
    int numDia;
    int numMes;
    int numYear;

    public LibFechas(int fechaBase){
        this.fechaBase = fechaBase;        
        numDia = Math.abs(fechaBase) % 100;
        numMes = (fechaBase % 10000) / 100;
        numYear = fechaBase / 10000;
        diaSemana = calculaDiaSemana();
    }

    public String calculaDiaSemana(){
        String fechaStr = String.valueOf(fechaBase);
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = sdfInput.parse(fechaStr);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            // La variable 'dayOfWeek' contiene el valor numérico del día de la semana
            switch (dayOfWeek) {
                case Calendar.SUNDAY:
                    return "Domingo";
                case Calendar.MONDAY:
                    return "Lunes";
                case Calendar.TUESDAY:
                    return "Martes";
                case Calendar.WEDNESDAY:
                    return "Miércoles";
                case Calendar.THURSDAY:
                    return "Jueves";
                case Calendar.FRIDAY:
                    return "Viernes";
                case Calendar.SATURDAY:
                    return "Sábado";
                default:
                    return "Error al calcular el día de la semana";
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return "Error al parsear la fecha";
        }
    }
    
    public String getDiaSemana(){
        return diaSemana;
    }

    public String getDiaSemanaYFecha(){
        return diaSemana + " " + numDia + "/" + numMes + "/" + numYear;
    }

    public int getNumDia(){
        return numDia;
    }

    public int getNumMes(){
        return numMes;
    }

    public int getNumYear(){
        return numYear;
    }

}
