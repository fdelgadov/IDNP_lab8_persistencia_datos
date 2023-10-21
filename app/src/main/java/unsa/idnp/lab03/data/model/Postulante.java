package unsa.idnp.lab03.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Postulante implements Parcelable {

    private String DNI;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String fechaNacimiento;
    private String colegioProcedencia;
    private String carrera;

    public Postulante(String dni, String apellidoPaterno, String apellidoMaterno, String nombres,
                      String fechaNacimiento, String colegioProcedencia, String carrera) {
        this.DNI = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.colegioProcedencia = colegioProcedencia;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Postulante{" +
                "DNI = " + DNI  + '\'' +
                "apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nombres='" + nombres + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", colegioProcedencia='" + colegioProcedencia + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }

    // Getters y setters para todas las propiedades (puedes generarlos automáticamente en tu IDE)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getColegioProcedencia() {
        return colegioProcedencia;
    }

    public void setColegioProcedencia(String colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDNI(){
        return DNI;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.DNI);
        dest.writeString(this.apellidoPaterno);
        dest.writeString(this.apellidoMaterno);
        dest.writeString(this.nombres);
        dest.writeString(this.fechaNacimiento);
        dest.writeString(this.colegioProcedencia);
        dest.writeString(this.carrera);
    }

    public void readFromParcel(Parcel source) {
        this.DNI = source.readString();
        this.apellidoPaterno = source.readString();
        this.apellidoMaterno = source.readString();
        this.nombres = source.readString();
        this.fechaNacimiento = source.readString();
        this.colegioProcedencia = source.readString();
        this.carrera = source.readString();
    }

    protected Postulante(Parcel in) {
        this.DNI = in.readString();
        this.apellidoPaterno = in.readString();
        this.apellidoMaterno = in.readString();
        this.nombres = in.readString();
        this.fechaNacimiento = in.readString();
        this.colegioProcedencia = in.readString();
        this.carrera = in.readString();
    }

    public static final Parcelable.Creator<Postulante> CREATOR = new Parcelable.Creator<Postulante>() {
        @Override
        public Postulante createFromParcel(Parcel source) {
            return new Postulante(source);
        }

        @Override
        public Postulante[] newArray(int size) {
            return new Postulante[size];
        }
    };
}





