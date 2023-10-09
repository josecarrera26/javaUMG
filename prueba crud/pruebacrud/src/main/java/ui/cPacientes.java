/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controlador.RegistropacienteJpaController;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import modelo.Registropaciente;

/**
 *
 * @author ferna
 */
@Named
@ManagedBean
@RequestScoped
public class cPacientes implements Serializable {

    //instaciar clase de controlador
    private RegistropacienteJpaController tjc = new RegistropacienteJpaController();

    private int idPaciente;
    private String nombrePaciente;
    private String direccionPaciente;
    private int telefonoPaciente;
    private String enfermedad;
    private String estado;
    private String fecha;

    public cPacientes(int idPaciente, String nombrePaciente, String direccionPaciente, int telefonoPaciente, String enfermedad, String estado, String fecha) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.direccionPaciente = direccionPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.fecha = fecha;

    }

    public cPacientes() {
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public int getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(int telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //instanciar modelo
    private Registropaciente paciente = new Registropaciente();

    public void insertarPersona() {
        try {
            //por ser autoincrementable
            paciente.setIdpaciente(Integer.BYTES);

            paciente.setNombrepaciente(nombrePaciente);
            paciente.setDireccion(direccionPaciente);
            paciente.setEnfermedad(enfermedad);
            paciente.setEstado(estado);
            // Convertir la cadena de fecha a un objeto Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaDate = sdf.parse(fecha);

            // Configurar la fecha en el paciente
            paciente.setFechaalta(fechaDate);

            paciente.setTelefono(telefonoPaciente);

            //insertar datos al controlador
            tjc.create(paciente);

            // Mostrar un mensaje de éxito
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Paciente insertado con éxito."));
        } catch (Exception e) {
            // Manejar errores aquí, por ejemplo, mostrar un mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo insertar el paciente."));
            e.printStackTrace();

        }
    }

    public void eliminarPaciente() {
        try {

            //insertar datos al controlador
            tjc.destroy(idPaciente);

            // Mostrar un mensaje de éxito
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Paciente insertado con éxito."));
        } catch (Exception e) {
            // Manejar errores aquí, por ejemplo, mostrar un mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo insertar el paciente."));
            e.printStackTrace();

        }

    }

    public List<Registropaciente> listarPacientes() {
        //lista de la entidad
        List<Registropaciente> todosLosPacientes = new ArrayList<>();
        Iterable<Registropaciente> listaPacientes = tjc.findRegistropacienteEntities();

        // Recorre la lista utilizando un bucle for-each y agrega cada elemento a la nueva lista
        for (Registropaciente paciente : listaPacientes) {
            todosLosPacientes.add(paciente);
        }

        return todosLosPacientes;
    }

}
