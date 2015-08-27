package com.cobblesms

import fi.iki.elonen.NanoHTTPD
import fi.iki.elonen.NanoHTTPD.{IHTTPSession, Response}

class WebServer extends NanoHTTPD(8080) {

    override def serve(session: IHTTPSession): Response = {
        var msg = "<html><body><h1>Hello server</h1>\n"
        val parms = session.getParms
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" +
                "</form>\n"
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>"
        }
        newFixedLengthResponse(msg + "</body></html>\n")
    }
}
