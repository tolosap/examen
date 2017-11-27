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
package service;

import bean.PacienteBean;
import service.interfaces.TableServiceInterface;
import service.interfaces.EmptyServiceInterface;
import service.interfaces.ViewServiceInterface;
import com.google.gson.Gson;
import bean.ReplyBean;
import connection.ConnectionInterface;
import dao.PacienteDao;
import helper.AppConfigurationHelper;
import helper.FilterBeanHelper;
import helper.Log4j;
import helper.ParameterCook;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PacienteService {

    HttpServletRequest oRequest = null;

    public PacienteService(HttpServletRequest request) {
        oRequest = request;
    }

    public ReplyBean rellenar() throws Exception {
        int numReg = Integer.parseInt(oRequest.getParameter("num"));
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();
            for (int i = 1; i <= numReg; i++) {
                PacienteBean oPacienteBean = new PacienteBean();
                PacienteDao oDao = new PacienteDao(oConnection);

                //-------------------------------------DNI
                oPacienteBean.setDni("23321991Z");

                //-------------------------------------SEXO
                int numRNom = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);

                if (numRNom == 1) {
                    long numRNombreM = (long) Math.floor(Math.random() * (oDao.countGen("nombremasculino") - 1 + 1) + 1);
                    oPacienteBean.setNombre(oDao.getNombreM(numRNombreM));
                } else {
                    long numRNombreF = (long) Math.floor(Math.random() * (oDao.countGen("nombrefemenino") - 1 + 1) + 1);
                    oPacienteBean.setNombre(oDao.getNombreF(numRNombreF));
                }
                //-------------------------------------1ER APELLIDO
                long numRPrimApell = (long) Math.floor(Math.random() * (oDao.countGen("apellido") - 1 + 1) + 1);
                oPacienteBean.setPrimer_apellido(oDao.getPrimerApe(numRPrimApell));

                //-------------------------------------2DO APELLIDO
                long numR2doApe = (long) Math.floor(Math.random() * (oDao.countGen("apellido") - 1 + 1) + 1);
                oPacienteBean.setSegundo_apellido(oDao.getPrimerApe(numR2doApe));

                //-------------------------------------DIRECCION
                long via = (long) Math.floor(Math.random() * (oDao.countGen("via") - 1 + 1) + 1);
                String viaDirecc = oDao.getVia(via);
                int numRDirec = (int) Math.floor(Math.random() * 3);

                if (numRDirec == 1) {
                    long numRDirecM = (long) Math.floor(Math.random() * (oDao.countGen("nombremasculino") - 1 + 1) + 1);
                    String direcM = (oDao.getNombreM(numRDirecM));
                    long numRDirecAp = (long) Math.floor(Math.random() * (oDao.countGen("apellido") - 1 + 1) + 1);
                    String direcAp = (oDao.getPrimerApe(numRDirecAp));
                    oPacienteBean.setDireccion(viaDirecc + " de " + direcM + " " + direcAp);
                } else {
                    long numRDirecF = (long) Math.floor(Math.random() * (oDao.countGen("nombrefemenino") - 1 + 1) + 1);
                    String direcF = (oDao.getNombreM(numRDirecF));
                    long numRDirecAp = (long) Math.floor(Math.random() * (oDao.countGen("apellido") - 1 + 1) + 1);
                    String direcAp = (oDao.getPrimerApe(numRDirecAp));
                    oPacienteBean.setDireccion(viaDirecc + " de " + direcF + " " + direcAp);
                }

                //-------------------------------------MUNICIPIO
                long numRMunicipio = (long) Math.floor(Math.random() * (oDao.countGen("municipio") - 1 + 1) + 1);
                Integer IDProv = oDao.getProvinciaMunicipio(numRMunicipio);
                Integer IDComunidad = oDao.getComunidadMunicipio(numRMunicipio);
                oPacienteBean.setMunicipio(oDao.getMunicipio(numRMunicipio));

                //-------------------------------------CODIGO POSTAL
                long numRCP = (long) Math.floor(Math.random() * 1000);
                oPacienteBean.setCodigo_postal("46" + numRCP);

                //-------------------------------------PROVINCIA
                String provincia = oDao.getProvincia(IDProv);
                String comunidad = oDao.getComunidad(IDComunidad);
                oPacienteBean.setProvincia(provincia + " (" + comunidad + ")");

                //-------------------------------------PAIS
                oPacienteBean.setPais("España");

                //-------------------------------------EMAIL
                oPacienteBean.setEmail(oPacienteBean.getNombre().substring(0, 2)
                        + oPacienteBean.getPrimer_apellido().substring(0, 2)
                        + oPacienteBean.getSegundo_apellido().substring(0, 2) + "@"
                        + oPacienteBean.getPrimer_apellido() + ".es");

                //-------------------------------------TELEFONO 1
                long numTLF1 = (long) Math.floor(Math.random() * 10000000);
                long numTLFR = (long) Math.floor(Math.random() * 3);
                if (numTLFR == 1) {
                    oPacienteBean.setTlf1("64" + numTLF1);
                } else {
                    oPacienteBean.setTlf1("62" + numTLF1);
                }

                //-------------------------------------TELEFONO 2
                long numTLF2 = (long) Math.floor(Math.random() * 10000000);
                long numTLFR2 = (long) Math.floor(Math.random() * 3);
                if (numTLFR2 == 1 && (oPacienteBean.getTlf1() != ("64" + numTLF2))) {
                    oPacienteBean.setTlf2("64" + numTLF2);
                } else {
                    oPacienteBean.setTlf2("62" + numTLF2);
                }

                //-------------------------------------NOMBRE PADRE
                long numRNombrePadre = (long) Math.floor(Math.random() * (oDao.countGen("nombremasculino") - 1 + 1) + 1);
                oPacienteBean.setNombre_padre(oDao.getNombreM(numRNombrePadre));

                //-------------------------------------NOMBRE MADRE
                long numRNombreMadre = (long) Math.floor(Math.random() * (oDao.countGen("nombrefemenino") - 1 + 1) + 1);
                oPacienteBean.setNombre_madre(oDao.getNombreF(numRNombreMadre));

                //-------------------------------------FECHA DE NACIMIENTO
                Date startDate = new GregorianCalendar(1945, Calendar.JANUARY, 1).getTime();
                Date endDate = new GregorianCalendar(2015, Calendar.JANUARY, 1).getTime();
                long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
                Date date = new Date(random);
                oPacienteBean.setFechaNace(date);

                //-------------------------------------CIUDAD NACIMIENTO
                long numRCid = (long) Math.floor(Math.random() * (oDao.countGen("municipio") - 1 + 1) + 1);
                //idprovincia
                Integer idprov = oDao.getProvinciaMunicipio(numRCid);
                oPacienteBean.setCiudadNace(oDao.getMunicipio(numRCid) + " (" + oDao.getProvincia(idprov) + ")");

                //-------------------------------------PAIS NACIMIENTO
                oPacienteBean.setPaisNace("España");

                //-------------------------------------SIP ASEGURADORA
                long numRAseg = (long) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                String strSIP = Long.toString(numRAseg);
                oPacienteBean.setSip_ase(strSIP);

                //-------------------------------------TIPO DE PAGO
                Integer numPag = (int) (long) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                oPacienteBean.setId_tipopago(numPag);

                //-------------------------------------SEXO
                oPacienteBean.setSexo(numRNom);

                //-------------------------------------ID PACIENTE
                oPacienteBean.setId_usuario(1);

                //-------------------------------------CREAR PACIENTE
                oDao.set(oPacienteBean);

            }
            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(numReg);
            oReplyBean = new ReplyBean(200, strJson);

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;

    }

    public ReplyBean getpage() throws Exception {
        int np = Integer.parseInt(oRequest.getParameter("np"));
        int rpp = Integer.parseInt(oRequest.getParameter("rpp"));
        String strOrder = oRequest.getParameter("order");
        String strFilter = oRequest.getParameter("filter");
        LinkedHashMap<String, String> hmOrder = ParameterCook.getOrderParams(strOrder);
        ArrayList<FilterBeanHelper> alFilter = ParameterCook.getFilterParams(strFilter);
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        ArrayList<PacienteBean> aloBean = null;
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();

            PacienteDao oDao = new PacienteDao(oConnection);
            aloBean = oDao.getPage(rpp, np, hmOrder, alFilter);

            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(aloBean);
            oReplyBean = new ReplyBean(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;

    }

    /*
    * FUNCIONA
     */
    public ReplyBean getcount() throws Exception {
        Long lResult;
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        String strFilter = oRequest.getParameter("filter");
        ArrayList<FilterBeanHelper> alFilter = ParameterCook.getFilterParams(strFilter);
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();

            PacienteDao oDao = new PacienteDao(oConnection);
            lResult = oDao.getCount(alFilter);

            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(lResult);
            oReplyBean = new ReplyBean(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;

    }

    /*
    * FUNCIONA
     */
    public ReplyBean remove() throws Exception {

        //int id = Integer.parseInt(oRequest.getParameter("id"));
        Boolean iResult = false;
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();

            PacienteDao oDao = new PacienteDao(oConnection);
            iResult = oDao.remove();

            Gson oGson = AppConfigurationHelper.getGson();
            //String strJson = oGson.toJson(iResult);
            oReplyBean = new ReplyBean(200, "OK");
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4j.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;

    }

}
