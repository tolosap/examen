/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author a023321991z
 */
public class PacienteBean {
    private Integer id;
    private String dni;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String direccion;
    private String municipio;
    private Long codigo_postal;
    private String provincia;
    private String pais;
    private String email;
    private Long tlf1;
    private Long tlf2;
    private String nombre_padre;
    private String nombre_madre;
    private Date fechaNace;
    private String ciudadNace;
    private String paisNace;
    private Long sip_ase;
    private Long id_tipopago;
    private Integer sexo;
    private Integer id_usuario;

    public PacienteBean(String dni, String nombre, String primer_apellido, String segundo_apellido, String direccion, String municipio, Long codigo_postal, String provincia, String pais, String email, Long tlf1, Long tlf2, String nombre_padre, String nombre_madre, Date fechaNace, String ciudadNace, String paisNace, Long sip_ase, Long id_tipopago, Integer sexo, Integer id_usuario) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Long getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(Long id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public PacienteBean() {
        
    }
    public PacienteBean(Integer id) {
        this.id = id;
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

    public Long getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Long codigo_postal) {
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

    public Long getTlf1() {
        return tlf1;
    }

    public void setTlf1(Long tlf1) {
        this.tlf1 = tlf1;
    }

    public Long getTlf2() {
        return tlf2;
    }

    public void setTlf2(Long tlf2) {
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

    public Long getSip_ase() {
        return sip_ase;
    }

    public void setSip_ase(Long sip_ase) {
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
    
    
    
}
