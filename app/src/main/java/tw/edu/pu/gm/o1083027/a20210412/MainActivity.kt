package tw.edu.pu.gm.o1083027.a20210412

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener{

    lateinit var gDetector: GestureDetector

    var PictureNo:Int = 0  //目前顯示第幾張圖
    var TotalPictures:Int = 0 //總共幾張圖片(假設僅顯示pu0-pu3)


    fun ShowPicture(){
        /*
 when (PictureNo){
     0 -> img.setImageResource(R.drawable.pu0)
     1 -> img.setImageResource(R.drawable.pu1)
     2 -> img.setImageResource(R.drawable.pu2)
     3 -> img.setImageResource(R.drawable.pu3)
 }
 */
        var res:Int = getResources().getIdentifier("pu" + (PictureNo),
            "drawable", getPackageName())
        img.setImageResource(res)
        txv.text =PictureNo.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this, this)


        var res:Int = -1
        var countDrawables:Int = -1
        while (res != 0) {
            countDrawables++;
            res = getResources().getIdentifier("pu" + (countDrawables),
            "drawable", getPackageName());
        }
        TotalPictures = countDrawables
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

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        PictureNo = 0
        ShowPicture()


        return true

    }

    override fun onDown(e: MotionEvent?): Boolean {
        // TODO("Not yet implemented")

        return true

    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        if (e1.getX() < e2.getX()){  //向右快滑
            PictureNo++
            if (PictureNo == TotalPictures) {PictureNo = 0}
        }
        else{     //向左快滑
            PictureNo--;
            if (PictureNo < 0) {PictureNo = TotalPictures - 1 }
        }
        ShowPicture()
        return true

    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //TODO("Not yet implemented")

        return true

    }

    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
        PictureNo = TotalPictures - 1
        ShowPicture()



    }
}




