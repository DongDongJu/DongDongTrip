package koomin.cs.dongdongtrip;

/**
 * Created by grid on 16. 5. 8..
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    private void initializeData(){
        states = new ArrayList<>();
        states.add(new State("숭례문", "숭례문은 조선의 수도인 한양의 4대문 중의 하나로 남쪽의 대문이다.", R.drawable.srm));
        states.add(new State("경복궁", "경복궁은 대한민국 서울 세종로에 있는 조선 왕조의 법궁이다.",R.drawable.kbg));
        states.add(new State("N서울타워", "N서울타워는 대한민국 서울특별시 용산구 용산동 2가 남산 공원 정상 부근에 위치한 전파 송출 및 관광용 타워이다.",R.drawable.nst));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(states);
        rv.setAdapter(adapter);
    }
}
