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
import dao.UsuarioDao;
import helper.AppConfigurationHelper;
import helper.FilterBeanHelper;
import helper.Log4j;
import helper.ParameterCook;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.*;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UsuarioService {

    HttpServletRequest oRequest = null;

    public UsuarioService(HttpServletRequest request) {
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
                UsuarioDao oDao = new UsuarioDao(oConnection);
                
                oPacienteBean.setDni("23321991Z");

                int numRNom = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
                
                //se escoge el sexo
                if (numRNom == 1) {
                    long numRNombreM = (long) Math.floor(Math.random() * (oDao.countGen("nombremasculino")) + 1);
                    oPacienteBean.setNombre(oDao.getNombreM(numRNombreM));
                } else {
                    long numRNombreF = (long) Math.floor(Math.random() * (oDao.countGen("nombrefemenino")) + 1);
                    oPacienteBean.setNombre(oDao.getNombreF(numRNombreF));
                }
                //1er ape
                long numRPrimApell = (long) Math.floor(Math.random() * (oDao.countGen("apellido")) + 1);
                oPacienteBean.setPrimer_apellido(oDao.getPrimerApe(numRPrimApell));

                //2do apel
                long numR2doApe = (long) Math.floor(Math.random() * (oDao.countGen("apellido")) + 1);
                oPacienteBean.setSegundo_apellido(oDao.getPrimerApe(numR2doApe));

                //Direccion
                long via = (long) Math.floor(Math.random() * (oDao.countGen("via")) + 1);
                String viaDirecc = oDao.getVia(via);
                int numRDirec = (int) Math.floor(Math.random() * 3);

                if (numRDirec == 1) {
                    long numRDirecM = (long) Math.floor(Math.random() * (oDao.countGen("nombremasculino")) + 1);
                    String direcM = (oDao.getNombreM(numRDirecM));
                    long numRDirecAp = (long) Math.floor(Math.random() * (oDao.countGen("apellido")) + 1);
                    String direcAp = (oDao.getPrimerApe(numRDirecAp));
                    oPacienteBean.setDireccion(viaDirecc + " de " + direcM + " " + direcAp);
                } else {
                    long numRDirecF = (long) Math.floor(Math.random() * (oDao.countGen("nombrefemenino")) + 1);
                    String direcF = (oDao.getNombreM(numRDirecF));
                    long numRDirecAp = (long) Math.floor(Math.random() * (oDao.countGen("apellido")) + 1);
                    String direcAp = (oDao.getPrimerApe(numRDirecAp));
                    oPacienteBean.setDireccion(viaDirecc + " de " + direcF + " " + direcAp);
                }

                //Municipio
                long numRMunicipio = (long) Math.floor(Math.random() * (oDao.countGen("municipio")) + 1);
                oPacienteBean.setMunicipio(oDao.getMunicipio(numRMunicipio));

                //CP
                long numRCP = (long) Math.floor(Math.random() * 1000);
                oPacienteBean.setCodigo_postal(46000 + numRCP);

                //Provincia
                oPacienteBean.setProvincia("Alaba");
                
                //Pais
                oPacienteBean.setPais("España");

                //email
                oPacienteBean.setEmail(oPacienteBean.getNombre().substring(0, 2)
                        + oPacienteBean.getPrimer_apellido().substring(0, 2)
                        + oPacienteBean.getSegundo_apellido().substring(0, 2) + "@"
                        + oPacienteBean.getPrimer_apellido() + ".es");

                //tlf1
                long numTLF1 = (long) Math.floor(Math.random() * 10000000);
                long numTLFR = (long) Math.floor(Math.random() * 3);
                if (numTLFR == 1) {
                    oPacienteBean.setTlf1(640000000 + numTLF1);
                } else {
                    oPacienteBean.setTlf1(620000000 + numTLF1);
                }

                //tlf2
                long numTLF2 = (long) Math.floor(Math.random() * 10000000);
                long numTLFR2 = (long) Math.floor(Math.random() * 3);
                if (numTLFR2 == 1) {
                    oPacienteBean.setTlf2(640000000 + numTLF2);
                } else {
                    oPacienteBean.setTlf2(620000000 + numTLF2);
                }

                //nombre_padre
                long numRNombrePadre = (long) Math.floor(Math.random() * (oDao.countGen("nombremasculino")) + 1);
                oPacienteBean.setNombre_padre(oDao.getNombreM(numRNombrePadre));

                //mnombre_madre
                long numRNombreMadre = (long) Math.floor(Math.random() * (oDao.countGen("nombrefemenino")) + 1);
                oPacienteBean.setNombre_madre(oDao.getNombreF(numRNombreMadre));

                //Fecha nacimiento
                Date fecha = new Date(2017 / 10 / 26);
                oPacienteBean.setFechaNace(fecha);

                //ciudad nace FALTA
                long numRCid = (long) Math.floor(Math.random() * (oDao.countGen("municipio")) + 1);
                oPacienteBean.setCiudadNace(oDao.getMunicipio(numRCid) + " ");

                //pais nac
                oPacienteBean.setPaisNace("España");

                //sip aseguradora
                long numRAseg = (long) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                oPacienteBean.setSip_ase(numRAseg);

                //tipo pago
                long numPag = (long) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                oPacienteBean.setId_tipopago(numPag);

                //sexo
                oPacienteBean.setSexo(numRNom);

                //id user
                oPacienteBean.setId_usuario(1);

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

    /*public ReplyBean getpage() throws Exception {

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

            UsuarioDao oDao = new UsuarioDao(oConnection);
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

    }*/

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

            UsuarioDao oDao = new UsuarioDao(oConnection);
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

            UsuarioDao oDao = new UsuarioDao(oConnection);
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
