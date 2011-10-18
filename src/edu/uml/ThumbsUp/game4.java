package edu.uml.thumbsup;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class game4 extends Activity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new Panel(this));
    }
	
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}

	private void game_help() {
		// prepare the alert box
		AlertDialog.Builder helpbox = new AlertDialog.Builder(this);
		// set the message to display
		helpbox.setMessage("Fill fishes into the Aquarium by touching the screen. You can win a prize money of 100$ every month!");
		// add a neutral button to help box and assign a click listener
		helpbox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface arg0, int arg1) {
			 //the button is clicked
			 Toast.makeText(getApplicationContext(), "Back to Game", Toast.LENGTH_LONG).show();	
			}
		});
		helpbox.show();		
	}

	

	class Panel extends SurfaceView implements SurfaceHolder.Callback {
    	private TutorialThread _thread;
        private ArrayList<GraphicObject> _graphics = new ArrayList<GraphicObject>();
 
        public Panel(Context context) {
            super(context);
            getHolder().addCallback(this);
            _thread = new TutorialThread(getHolder(), this);
            setFocusable(true);
        }
 
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            synchronized (_thread.getSurfaceHolder()) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    GraphicObject graphic = new GraphicObject(BitmapFactory.decodeResource(getResources(), R.drawable.fish));
                    graphic.getCoordinates().setX((int) event.getX() - graphic.getGraphic().getWidth() / 2);
                    graphic.getCoordinates().setY((int) event.getY() - graphic.getGraphic().getHeight() / 2);
                    _graphics.add(graphic);
                }
                return true;
            }
        }
 
        
        
    public void updatePhysics() {
            GraphicObject.Coordinates coord;
            GraphicObject.Speed speed;
    
            for (GraphicObject graphic : _graphics) {
                  coord = graphic.getCoordinates();
                  speed = graphic.getSpeed();
 
                // Direction
                if (speed.getXDirection() == GraphicObject.Speed.X_DIRECTION_RIGHT) {
                    coord.setX(coord.getX() + speed.getX());
                } else {
                    coord.setX(coord.getX() - speed.getX());
                }
                if (speed.getYDirection() == GraphicObject.Speed.Y_DIRECTION_DOWN) {
                    coord.setY(coord.getY() + speed.getY());                
                } else {
                    coord.setY(coord.getY() - speed.getY());                
                }
 
                // borders for x...
                if (coord.getX() < 0) {
                    speed.toggleXDirection();
                    coord.setX(-coord.getX());
                } else if (coord.getX() + graphic.getGraphic().getWidth() > getWidth()) {
                    speed.toggleXDirection();
                    coord.setX(coord.getX() + getWidth() - (coord.getX() + graphic.getGraphic().getWidth()));
                }
 
                // borders for y...
                if (coord.getY() < 0) {
                    speed.toggleYDirection();
                    coord.setY(-coord.getY());
                } else if (coord.getY() + graphic.getGraphic().getHeight() > getHeight()) {
                    speed.toggleYDirection();
                    coord.setY(coord.getY() + getHeight() - (coord.getY() + graphic.getGraphic().getHeight()));
                }
            }
   }
 
    
    
    @Override
    public void onDraw(Canvas canvas) {
        	int counter = 0;
            Paint paint = new Paint();
            paint.setColor(Color.RED);
        	paint.setStyle(Paint.Style.FILL);
        	paint.setAntiAlias(true);
        	paint.setTextSize(25);            
            
            canvas.drawColor(Color.rgb(29, 155, 225));
            Bitmap bitmap;
            GraphicObject.Coordinates coords;
            
            
            for (GraphicObject graphic : _graphics) {
            	counter = counter + 1;            	
                bitmap = graphic.getGraphic();
                coords = graphic.getCoordinates();
                canvas.drawBitmap(bitmap, coords.getX(), coords.getY(), null);
            }
            
                //canvas.clipRect(0, 10, canvas.getWidth(), canvas.getWidth());
                canvas.drawText("Number of Fishes:  " + counter, (canvas.getWidth()/canvas.getWidth())+ 5, (canvas.getHeight()/1)- 5, paint);
        }
 
      
   public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            // TODO Auto-generated method stub
        }
 
   public void surfaceCreated(SurfaceHolder holder) {
            _thread.setRunning(true);
            _thread.start();
        }
 
   public void surfaceDestroyed(SurfaceHolder holder) {
            // simply copied from sample application LunarLander:
            // we have to tell thread to shut down & wait for it to finish, or else
            // it might touch the Surface after we return and explode
            boolean retry = true;
            _thread.setRunning(false);
            while (retry) {
                try {
                    _thread.join();
                    retry = false;
                } catch (InterruptedException e) {
                    // we will try it again and again...
                }
            }
        }
    }
 
    
    
    class TutorialThread extends Thread {
        private SurfaceHolder _surfaceHolder;
        private Panel _panel;
        private boolean _run = false;
 
        public TutorialThread(SurfaceHolder surfaceHolder, Panel panel) {
            _surfaceHolder = surfaceHolder;
            _panel = panel;
        }
 
        public void setRunning(boolean run) {
            _run = run;
        }
 
        public SurfaceHolder getSurfaceHolder() {
            return _surfaceHolder;
        }
 
        @Override
        public void run() {
            Canvas c;
            while (_run) {
                c = null;
                try {
                    c = _surfaceHolder.lockCanvas(null);
                    synchronized (_surfaceHolder) {
                        _panel.updatePhysics();
                        _panel.onDraw(c);
                    }
                } finally {
                    // do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        _surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
    }
 
    
    
    
    class GraphicObject {
        public class Speed {
            public static final int X_DIRECTION_RIGHT = 1;
            public static final int X_DIRECTION_LEFT = -1;
            public static final int Y_DIRECTION_DOWN = 1;
            public static final int Y_DIRECTION_UP = -1;
 
            private int _x = 1;
            private int _y = 1;
 
            private int _xDirection = X_DIRECTION_RIGHT;
            private int _yDirection = Y_DIRECTION_DOWN;
 
            /**
             * @return the _xDirection
             */
            public int getXDirection() {
                return _xDirection;
            }
 
            /**
             * @param direction the _xDirection to set
             */
            public void setXDirection(int direction) {
                _xDirection = direction;
            }
 
            public void toggleXDirection() {
                if (_xDirection == X_DIRECTION_RIGHT) {
                    _xDirection = X_DIRECTION_LEFT;
                } else {
                    _xDirection = X_DIRECTION_RIGHT;
                }
            }
 
            /**
             * @return the _yDirection
             */
            public int getYDirection() {
                return _yDirection;
            }
 
            /**
             * @param direction the _yDirection to set
             */
            public void setYDirection(int direction) {
                _yDirection = direction;
            }
 
            public void toggleYDirection() {
                if (_yDirection == Y_DIRECTION_DOWN) {
                    _yDirection = Y_DIRECTION_UP;
                } else {
                    _yDirection = Y_DIRECTION_DOWN;
                }
            }
 
            /**
             * @return the _x
             */
            public int getX() {
                return _x;
            }
 
            /**
             * @param speed the _x to set
             */
            public void setX(int speed) {
                _x = speed;
            }
 
            /**
             * @return the _y
             */
            public int getY() {
                return _y;
            }
 
            /**
             * @param speed the _y to set
             */
            public void setY(int speed) {
                _y = speed;
            }
 
            public String toString() {
                String xDirection;
                if (_xDirection == X_DIRECTION_RIGHT) {
                    xDirection = "right";
                } else {
                    xDirection = "left";
                }
                return "Speed: x: " + _x + " | y: " + _y + " | xDirection: " + xDirection;
            }
        }
 
        /**
         * Contains the coordinates of the graphic.
         */
        public class Coordinates {
            private int _x = 100;
            private int _y = 0;
 
            public int getX() {
                return _x + _bitmap.getWidth() / 2;
            }
 
            public void setX(int value) {
                _x = value - _bitmap.getWidth() / 2;
            }
 
            public int getY() {
                return _y + _bitmap.getHeight() / 2;
            }
 
            public void setY(int value) {
                _y = value - _bitmap.getHeight() / 2;
            }
 
            public String toString() {
                return "Coordinates: (" + _x + "/" + _y + ")";
            }
        }
 
        private Bitmap _bitmap;
        private Coordinates _coordinates;
        private Speed _speed;
 
        public GraphicObject(Bitmap bitmap) {
            _bitmap = bitmap;
            _coordinates = new Coordinates();
            _speed = new Speed();
        }
 
        public Bitmap getGraphic() {
            return _bitmap;
        }
 
        public Speed getSpeed() {
            return _speed;
        }
 
        public Coordinates getCoordinates() {
            return _coordinates;
        }
    }
}
