/*
 * Copyright (c) 2017 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 *
 * carrito-server: Helps you to develop easily AJAX web applications
 *               by copying and modifying this Java Server.
 *
 * Sources at https://github.com/rafaelaznar/carrito-server
 *
 * carrito-server is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dao;

import bean.PacienteBean;
import helper.AppConfigurationHelper;
import helper.EncodingUtilHelper;
import helper.FilterBeanHelper;
import helper.Log4j;
import helper.SqlBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

public class PacienteDao {

    private String strTable = "paciente";
    private String strSQL = "select * from " + strTable + " WHERE 1=1 ";
    private Connection oConnection = null;

    public PacienteDao(Connection oPooledConnection) {
        oConnection = oPooledConnection;
    }

    ///////////////
    public Long countGen(String strCount) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT COUNT(*) FROM " + strCount;
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getcount";
                Log4j.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public String getNombreM(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from nombremasculino WHERE 1=1 ";
        strSQL += " AND id=" + id;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);

            if (oResultSet.next()) {
                result = oResultSet.getString("nombre");
            } else {

            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    public String getNombreF(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from nombrefemenino WHERE 1=1 ";
        strSQL += " AND id=" + id;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("nombre");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    /////////////////////
    public String getPrimerApe(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from apellido WHERE 1=1 ";
        strSQL += " AND id=" + id;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("apellido");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    ////////////
    public String getSegundoApe(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from apellido WHERE 1=1 ";
        strSQL += " AND id=" + id;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("apellido");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    ////////////
    public String getMunicipio(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from municipio WHERE 1=1 ";
        strSQL += " AND id=" + id;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("nombre");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    public Integer getProvinciaMunicipio(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from municipio WHERE 1=1 ";
        strSQL += " AND id=" + id;
        Integer result = 0;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getInt("id_provincia");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    public Integer getComunidadMunicipio(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from municipio WHERE 1=1 ";
        strSQL += " AND id=" + id;
        Integer result = 0;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getInt("id_comunidad");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    //////
    public String getProvincia(Integer IDProv) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from provincia WHERE 1=1 ";
        strSQL += " AND id=" + IDProv;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("provincia");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    public String getComunidad(Integer IDProv) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from comunidad WHERE 1=1 ";
        strSQL += " AND id=" + IDProv;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("comunidad");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    //////
    public String getVia(long id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from via WHERE 1=1 ";
        strSQL += " AND id=" + id;
        String result = "";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                result = oResultSet.getString("via");
            } else {
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    //////
    public Integer set(PacienteBean oBean) throws Exception {
        PreparedStatement oPreparedStatement = null;
        Integer iResult = 0;
        Boolean insert = true;
        try {
            //if (oBean.getId() == null || oBean.getId() <= 0) {
            strSQL = "INSERT INTO " + strTable;
            strSQL += "(";
            strSQL += "dni,";
            strSQL += "nombre,";
            strSQL += "primer_apellido,";
            strSQL += "segundo_apellido,";
            strSQL += "direccion,";
            strSQL += "ciudad,";
            strSQL += "codigo_postal,";
            strSQL += "provincia,";
            strSQL += "pais,";
            strSQL += "email,";
            strSQL += "telefono1,";
            strSQL += "telefono2,";
            strSQL += "nombre_padre,";
            strSQL += "nombre_madre,";
            strSQL += "fecha_nacimiento,";
            strSQL += "ciudad_nacimiento,";
            strSQL += "pais_nacimiento,";
            strSQL += "sip_aseguradora,";
            strSQL += "id_tipopago,";
            strSQL += "id_sexo,";
            strSQL += "id_usuario";
            strSQL += ")";
            strSQL += " VALUES ";
            strSQL += "(";
            strSQL += EncodingUtilHelper.quotate(oBean.getDni()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getNombre()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getPrimer_apellido()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getSegundo_apellido()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getDireccion()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getMunicipio()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getCodigo_postal()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getProvincia()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getPais()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getEmail()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getTlf1()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getTlf2()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getNombre_padre()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getNombre_madre()) + ",";
            strSQL += EncodingUtilHelper.stringifyAndQuotate(oBean.getFechaNace()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getCiudadNace()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getPais()) + ",";
            strSQL += EncodingUtilHelper.quotate(oBean.getSip_ase()) + ",";
            strSQL += oBean.getId_tipopago() + ",";
            strSQL += oBean.getSexo() + ",";
            strSQL += oBean.getId_usuario();
            strSQL += ")";
            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            iResult = oPreparedStatement.executeUpdate();
            if (iResult < 1) {
                String msg = this.getClass().getName() + ": set";
                Log4j.errorLog(msg);
                throw new Exception(msg);
            }
            if (insert) {
                ResultSet oResultSet = oPreparedStatement.getGeneratedKeys();
                oResultSet.next();
                iResult = oResultSet.getInt(1);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public Boolean remove() throws Exception {
        boolean iResult = false;
        strSQL = "DELETE FROM " + strTable + " WHERE 1=1";
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            iResult = oPreparedStatement.execute();
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public PacienteBean get(PacienteBean oBean) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "select * from " + strTable + " WHERE 1=1 ";
        strSQL += " AND id=" + oBean.getId();
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                oBean.setDni(oResultSet.getString("dni"));
                oBean.setNombre(oResultSet.getString("nombre"));
                oBean.setPrimer_apellido(oResultSet.getString("primer_apellido"));
                oBean.setSegundo_apellido(oResultSet.getString("segundo_apellido"));
                oBean.setSegundo_apellido(oResultSet.getString("segundo_apellido"));
                oBean.setDireccion(oResultSet.getString("direccion"));
                oBean.setMunicipio(oResultSet.getString("ciudad"));
                oBean.setCodigo_postal(oResultSet.getString("codigo_postal"));
                oBean.setProvincia(oResultSet.getString("provincia"));
                oBean.setPais(oResultSet.getString("pais"));
                oBean.setEmail(oResultSet.getString("email"));
                oBean.setTlf1(oResultSet.getString("telefono1"));
                oBean.setTlf2(oResultSet.getString("telefono1"));
                oBean.setNombre_padre(oResultSet.getString("nombre_padre"));
                oBean.setNombre_madre(oResultSet.getString("nombre_madre"));
                oBean.setFechaNace(oResultSet.getDate("fecha_nacimiento"));
                oBean.setCiudadNace(oResultSet.getString("ciudad_nacimiento"));
                oBean.setPaisNace(oResultSet.getString("pais_nacimiento"));
                oBean.setSip_ase(oResultSet.getString("sip_aseguradora"));
                oBean.setId_tipopago(oResultSet.getInt("id_tipopago"));
                oBean.setSexo(oResultSet.getInt("id_sexo"));
                oBean.setId_usuario(oResultSet.getInt("id_usuario"));
            } else {
                oBean = null;
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oBean;
    }

    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT COUNT(*) FROM " + strTable;
        strSQL += " WHERE 1=1 " + SqlBuilder.buildSqlFilter(alFilter);
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getcount";
                Log4j.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public ArrayList<PacienteBean> getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter) throws Exception {
        String strSQL1 = strSQL;
        strSQL1 += SqlBuilder.buildSqlFilter(alFilter);
        strSQL1 += SqlBuilder.buildSqlOrder(hmOrder);
        strSQL1 += SqlBuilder.buildSqlLimit(this.getCount(alFilter), intRegsPerPag, intPage);
        ArrayList<PacienteBean> aloBean = new ArrayList<>();
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL1);
            oResultSet = oPreparedStatement.executeQuery(strSQL1);
            while (oResultSet.next()) {
                aloBean.add(this.get(new PacienteBean(oResultSet.getInt("id"))));
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return aloBean;
    }
}
