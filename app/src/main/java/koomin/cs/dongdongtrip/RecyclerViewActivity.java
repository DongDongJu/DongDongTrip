package koomin.cs.dongdongtrip;

/**
 * Created by grid on 16. 5. 8..
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<State> states;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
    }
    public List<State> getStates(){
        return states;
    }
    private void initializeData(){
        states = new ArrayList<>();
        states.add(new State("숭례문", "숭례문은 조선의 수도인 한양의 4대문 중의 하나로 남쪽의 대문이다.", R.drawable.srm));
        states.add(new State("경복궁", "경복궁은 대한민국 서울 세종로에 있는 조선 왕조의 법궁이다.",R.drawable.kbg));
        states.add(new State("N서울타워", "N서울타워는 대한민국 서울특별시 용산구 용산동 2가 남산 공원 정상 부근에 위치한 전파 송출 및 관광용 타워이다.",R.drawable.nst));
        states.add(new State("롯데월드", "롯데월드, 또는 롯데월드 어드벤처는 서울특별시 송파구 올림픽로 240에 위치한 테마파크이다. ",R.drawable.rdwd));
        states.add(new State("63빌딩","63빌딩 혹은 63시티는 대한민국 서울특별시 영등포구의 여의도에 있는 마천루이다. ",R.drawable.st));
    }


    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(states);
        rv.setAdapter(adapter);

    }
}
