package com.tsalapova.bicyclerental.controller;

import com.tsalapova.bicyclerental.command.ActionCommand;
import com.tsalapova.bicyclerental.command.CommandFactory;
import com.tsalapova.bicyclerental.command.PageConstant;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/26/2017
 */
@WebServlet(urlPatterns = "/control")
public class InitialController extends HttpServlet {
    private static final String COMMAND = "command";
    private static final Logger LOGGER = LogManager.getLogger(InitialController.class);

    @Override
    public void init() throws ServletException {
        super.init();
        ConnectionPool.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);
        if (commandName != null) {
            try {
                ActionCommand command = CommandFactory.defineCommand(commandName);
                String page = command.execute(request);
                request.getRequestDispatcher(page).forward(request, response);
            } catch (CommandException e) {
                LOGGER.log(Level.WARN, "Exception while executing command "+ commandName+".", e);
                throw new ServletException(e);
            }
        } else {
            request.getRequestDispatcher(PageConstant.MAIN).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.getInstance().destroyPool();
    }
}
