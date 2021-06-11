package com.codegym.task.task32.task3209;

import com.codegym.task.task32.task3209.listeners.TextEditMenuListener;
import com.codegym.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    public void resetDocument() {
        if (document !=null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document =  (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();

    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML editor");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int selection = jFileChooser.showOpenDialog(view);
        if (selection == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader fileReader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null)
            saveDocumentAs();
        else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());

            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int selection = jFileChooser.showSaveDialog(view);
        if (selection == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }catch(Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void setPlainText(String text) {

        try {
            resetDocument();
            StringReader sr = new StringReader(text);
            new HTMLEditorKit().read(sr, document, 0);
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        try {
            StringWriter sw = new StringWriter();
            new HTMLEditorKit().write(sw, document, 0, document.getLength());
            return sw.toString();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
        return null;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void exit() {
        System.exit(0);
    }

    public void init() {
        createNewDocument();
    }
}
