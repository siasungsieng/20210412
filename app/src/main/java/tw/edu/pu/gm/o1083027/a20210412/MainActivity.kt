package tw.edu.pu.gm.o1083027.a20210412

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener{

    lateinit var gDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this,this)
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
       /* if (txv.text == "靜宜之美"){
            txv.text = "螢幕觸控"
        }
        else{
            txv.text = "靜宜之美"
        }
        txv.text="x="+ event?.x.toString()+ "\ny="+ event?.y.toString()

        */
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
       // TODO("Not yet implemented")
        txv.text = "按下後無後續動作"
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        txv.text = "短按"
        return true

    }

    override fun onDown(e: MotionEvent?): Boolean {
       // TODO("Not yet implemented")
        txv.text = "按下"
        return true

    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        txv.text = "快滑\nx1y1: " + e1.getX().toString() + ", " + e1.getY().toString() +
                "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString() +
                "\nX軸Y軸速度:" + velocityX.toString() + ", " +  velocityY.toString()
        return true

    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        txv.text = "拖曳\nx1y1: " +  e1.getX().toString() + ", " + e1.getY().toString() +
                "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString()
        return true

    }

    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
        txv.text = "長按"

    }
}
