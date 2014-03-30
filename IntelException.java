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
public class IntelException extends Exception {
    public IntelException(){
	
    }
    public IntelException(String message){
	super(message);
	
    }
    public IntelException(String message, Throwable cause){
	super(message, cause);
	
    }
    public IntelException(Throwable cause){
	super(cause);
	
    }
}
