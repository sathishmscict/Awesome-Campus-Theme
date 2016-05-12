package cn.edu.jxnu.awesome_campus.ui.jxnugo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import cn.edu.jxnu.awesome_campus.R;
import cn.edu.jxnu.awesome_campus.event.EVENT;
import cn.edu.jxnu.awesome_campus.event.EventModel;
import cn.edu.jxnu.awesome_campus.model.jxnugo.JxnuGoLoginBean;
import cn.edu.jxnu.awesome_campus.ui.base.BaseToolbarActivity;

public class JxnugoUserinfoActivity extends BaseToolbarActivity implements View.OnClickListener{


    TextView userDesc;
    TextView userPostNum;
    TextView userCollectNum;
    TextView userFollowerdNum;
    TextView userFollowingNum;
    TextView userLocate;

    public void initView(){
        userDesc=(TextView)findViewById(R.id.jxnugo_user_desc);
        userPostNum=(TextView)findViewById(R.id.jxnugo_user_posts);
        userCollectNum=(TextView)findViewById(R.id.jxnugo_user_collection);
        userFollowerdNum = (TextView)findViewById(R.id.jxnugo_user_followerd);
        userFollowingNum=(TextView)findViewById(R.id.jxnugo_user_following);
        userLocate=(TextView)findViewById(R.id.jxnugo_user_locate);
        View locate=findViewById(R.id.jxnugo_user_card_local);
        View posts=findViewById(R.id.jxnugo_user_card_posts);
        View collect=findViewById(R.id.jxnugo_user_card_collect);
        locate.setOnClickListener(this);
        posts.setOnClickListener(this);
        collect.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jxnugo_userinfo);
        initToolbar();
        loadUserInfo();
        initView();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onClick(View v) {
        Log.d("JXNU_GO","view onclick");
        switch (v.getId())
        {
            case R.id.jxnugo_user_card_collect:
                break;
            case R.id.jxnugo_user_card_local:
                break;
            case R.id.jxnugo_user_card_posts:
                break;
            default:
                break;
        }
    }

    public  void loadUserInfo(){
        EventModel model= EventBus.getDefault().getStickyEvent(EventModel.class);
        if(model!=null&&model.getEventCode()==EVENT.JXNUGO_USERINFO_LOAD_USER){
            JxnuGoLoginBean bean=(JxnuGoLoginBean) model.getData();
            Log.d("JXNU_GO","load sticky login bean"+bean.getMessage());
            setToolbarTitle("vczh");
            EventBus.getDefault().post(new EventModel<Void>(EVENT.JXNUGO_USERINFO_LOAD_USER_SUCCESS));
        }

    }

    @Subscribe
    public void onEventMainThread(EventModel eventModel){
       switch (eventModel.getEventCode())
       {
           case  EVENT.JXNUGO_USERINFO_LOAD_USER:
               break;
           case EVENT.JXNUGO_USERINFO_LOAD_USER_SUCCESS:
               break;
           case EVENT.JXNUGO_USERINFO_LOAD_USER_FALURE:
               break;
       }
    }


}