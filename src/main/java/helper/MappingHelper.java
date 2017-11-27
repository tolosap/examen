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
import javax.servlet.http.HttpServletRequest;

public class MappingHelper {

    public static ReplyBean executeMethodService(HttpServletRequest oRequest) throws Exception {
        String op = oRequest.getParameter("op");
        ReplyBean oReplyBean = null;
        Boolean oBool = null;

        PacienteService oUsuarioService = new PacienteService(oRequest);
        switch (op) {
            case "rellena":
                oReplyBean = oUsuarioService.rellenar();
                break;
            case "vacia":
                oReplyBean = oUsuarioService.remove();
                break;
            case "dump":
                oReplyBean = oUsuarioService.getpage();
                break;
            case "cuenta":
                oReplyBean = oUsuarioService.getcount();
                break;

            default:
                oReplyBean = new ReplyBean(500, "Operation not found : Please contact your administrator");
                break;
        }

        return oReplyBean;
    }
}
