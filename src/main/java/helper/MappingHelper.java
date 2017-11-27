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
package helper;

import bean.ReplyBean;
import service.PacienteService;
import service.TipousuarioService;
import service.UsuarioService;
import javax.servlet.http.HttpServletRequest;

public class MappingHelper {

    /*public static ReplyBean executeMethodService(HttpServletRequest oRequest) throws Exception {
        String op = oRequest.getParameter("op");
        ReplyBean oReplyBean = null;
        Boolean oBool = null;

        PacienteService oUsuarioService = new PacienteService(oRequest);
        switch (op) {


            default:
                oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                break;
        }

        return oReplyBean;
    }*/
    public static ReplyBean executeMethodService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBean oReplyBean = null;
        Boolean oBool = null;
        switch (ob) {
            case "usuario":
                UsuarioService oUsuarioService = new UsuarioService(oRequest);
                switch (op) {
                    case "get":
                        oReplyBean = oUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oUsuarioService.getpage();
                        break;
                    case "getcount":
                        oReplyBean = oUsuarioService.getcount();
                        break;
                    case "login":
                        oReplyBean = oUsuarioService.login();
                        break;
                    case "logout":
                        oReplyBean = oUsuarioService.logout();
                        break;
                    case "check":
                        oReplyBean = oUsuarioService.check();
                        break;
                    case "getcountxtipousuario":
                        oReplyBean = oUsuarioService.getcountxtiposuario();
                        break;
                    case "getpagextipousuario":
                        oReplyBean = oUsuarioService.getpagextipousuario();
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                        break;
                }
                break;
            case "tipousuario":
                TipousuarioService oTipousuarioService = new TipousuarioService(oRequest);
                switch (op) {
                    case "get":
                        oReplyBean = oTipousuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oTipousuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipousuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipousuarioService.getpage();
                        break;
                    case "getcount":
                        oReplyBean = oTipousuarioService.getcount();
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                        break;
                }
                break;
            case "paciente":
                PacienteService oPacienteService = new PacienteService(oRequest);
                switch (op) {
                    case "rellena":
                        oReplyBean = oPacienteService.rellenar();
                        break;
                    case "vacia":
                        oReplyBean = oPacienteService.remove();
                        break;
                    case "dump":
                        oReplyBean = oPacienteService.getpage();
                        break;
                    case "cuenta":
                        oReplyBean = oPacienteService.getcount();
                        break;
                }
                break;
        }
        return oReplyBean;
    }
}
