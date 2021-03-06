/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 *
 * @author a023321991z
 */
public class PacienteBean {
    private Integer id;
    @Expose
    private String dni;
    @Expose
    private String nombre;
    @Expose
    private String primer_apellido;
    @Expose
    private String segundo_apellido;
    @Expose
    private String direccion;
    @Expose
    private String municipio;
    @Expose
    private String codigo_postal;
    @Expose
    private String provincia;
    @Expose
    private String pais;
    @Expose
    private String email;
    @Expose
    private String tlf1;
    @Expose
    private String tlf2;
    @Expose
    private String nombre_padre;
    @Expose
    private String nombre_madre;
    @Expose
    private Date fechaNace;
    @Expose
    private String ciudadNace;
    @Expose
    private String paisNace;
    @Expose
    private String sip_ase;
    @Expose
    private Integer id_tipopago;
    @Expose
    private Integer sexo;
    @Expose
    private Integer id_usuario;

    public PacienteBean(String dni, String nombre, String primer_apellido, String segundo_apellido, String direccion, String municipio, String codigo_postal, String provincia, String pais, String email, String tlf1, String tlf2, String nombre_padre, String nombre_madre, Date fechaNace, String ciudadNace, String paisNace, String sip_ase, Integer id_tipopago, Integer sexo, Integer id_usuario) {
        this.dni = dni;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.direccion = direccion;
        this.municipio = municipio;
        this.codigo_postal = codigo_postal;
        this.provincia = provincia;
        this.pais = pais;
        this.email = email;
        this.tlf1 = tlf1;
        this.tlf2 = tlf2;
        this.nombre_padre = nombre_padre;
        this.nombre_madre = nombre_madre;
        this.fechaNace = fechaNace;
        this.ciudadNace = ciudadNace;
        this.paisNace = paisNace;
        this.sip_ase = sip_ase;
        this.id_tipopago = id_tipopago;
        this.sexo = sexo;
        this.id_usuario = id_usuario;
    }

    public PacienteBean(int aInt) {
        this.id = aInt;
    }
    
    public Integer getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(Integer id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public PacienteBean() {
        
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf1() {
        return tlf1;
    }

    public void setTlf1(String tlf1) {
        this.tlf1 = tlf1;
    }

    public String getTlf2() {
        return tlf2;
    }

    public void setTlf2(String tlf2) {
        this.tlf2 = tlf2;
    }

    public String getNombre_padre() {
        return nombre_padre;
    }

    public void setNombre_padre(String nombre_padre) {
        this.nombre_padre = nombre_padre;
    }

    public String getNombre_madre() {
        return nombre_madre;
    }

    public void setNombre_madre(String nombre_madre) {
        this.nombre_madre = nombre_madre;
    }

    public Date getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(Date fechaNace) {
        this.fechaNace = fechaNace;
    }

    public String getCiudadNace() {
        return ciudadNace;
    }

    public void setCiudadNace(String ciudadNace) {
        this.ciudadNace = ciudadNace;
    }

    public String getPaisNace() {
        return paisNace;
    }

    public void setPaisNace(String paisNace) {
        this.paisNace = paisNace;
    }

    public String getSip_ase() {
        return sip_ase;
    }

    public void setSip_ase(String sip_ase) {
        this.sip_ase = sip_ase;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
}
