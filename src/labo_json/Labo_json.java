package labo_json;

import static spark.Spark.*;
import spark.*;
import java.io.*;
import org.apache.commons.io.*;

public class Labo_json {

    public static void main(String[] args) {

        get(new Route("/"){
            @Override
            public Object handle(Request request, Response response){
                String file = null;
                try{
                    file = FileUtils.readFileToString(new File("views/home.html"));
                }catch(Exception e){
                    halt(500);
                    return null;
                }
                return file;
            }
        });

        get(new Route("/public/:filename"){
            @Override
            public String handle(Request request, Response response) {
                byte[] out = null;
                try{
                    out = IOUtils.toByteArray(new FileInputStream("public/"+request.params(":filename")));
                    String extension = request.params(":filename").substring(request.params(":filename").lastIndexOf(".")+1);
                    response.raw().setContentType("text/"+ extension +";charset=utf-8");
                    response.raw().getOutputStream().write(out, 0, out.length);
                }catch(Exception e){
                    halt(404);
                    return null;
                }
                halt(200);
                return null;
            }
        });
    }
}
