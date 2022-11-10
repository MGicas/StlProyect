package edu.uco.stl.crosscutting.execption;

import edu.uco.stl.crosscutting.exception.enumeration.LayerException;
import edu.uco.stl.crosscutting.helper.StringHelper;
import static edu.uco.stl.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.stl.crosscutting.helper.ObjectHelper.isNull;;

public class StlCustomException extends RuntimeException{

	private static final long serialVersionUID = 7151753075692579966L;
	
    private String userMessage; 
    private  LayerException layer;
    
    protected StlCustomException(final String userMessage, final LayerException layer, final String technicalMessage, final Throwable rootException) {
        super(technicalMessage, getDefaultIfNull(rootException, new Exception()));
        setUserMessage(userMessage);
        setLayer(layer);
    }
      
	public final String getUserMessage() {
		return userMessage;
	}
	public final void setUserMessage(final String userMessage) {
		this.userMessage = StringHelper.applyTrim(userMessage);
	}
	public final LayerException getLayer() {
		return layer;
	}
	public final void setLayer(final LayerException layer) {
		this.layer = layer;
	}
    
	public final boolean isTechinalException() {
        return isNull(getUserMessage());
    }
	
}
