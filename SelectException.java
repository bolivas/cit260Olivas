/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exception;

/**
 *
 * @author bensmac
 */
public class SelectException extends Exception {
    public SelectException(){
	
    }
    public SelectException(String message){
	super(message);
	
    }
    public SelectException(String message, Throwable cause){
	super(message, cause);
	
    }
    public SelectException(Throwable cause){
	super(cause);
	
    }
}
