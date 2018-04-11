import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class ActionKeyListenerPublic extends KeyAdapter {
	
	Timer listenerTime;
	int userKey;
	static int keyValue = 0;
	static int jumpValue = 0;

	public ActionKeyListenerPublic(){
		
	}
	
	public void  keyPressed(KeyEvent k){
		userKey = k.getKeyCode();
		
		if(userKey == KeyEvent.VK_LEFT){
			keyValue = 1;
		}else if(userKey == KeyEvent.VK_RIGHT){
			keyValue = -1;
		}else if(userKey == KeyEvent.VK_UP){
			jumpValue = 1;
		}
	}
	
	public void keyReleased(KeyEvent k){
		userKey = k.getKeyCode();
		
		if(userKey == KeyEvent.VK_LEFT || userKey == KeyEvent.VK_RIGHT){
			keyValue = 0;
		}
		if(userKey == KeyEvent.VK_UP){
			jumpValue = 0;
		}
	}
	
	public static int getKeyValue(){
		return keyValue;
	}
	
	public static int getJumpValue(){
		return jumpValue;
	}

}
