package com.sudhirkhanger.app.scorekeeper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScoreKeeperActivityFragment extends Fragment {

    private int team1Score;
    private int team2Score;
    private TextView team1;
    private TextView team2;
    private Button buttonAddTeam1;
    private Button buttonRemoveTeam1;
    private Button buttonAddTeam2;
    private Button buttonRemoveTeam2;
    private Button resetButton;

    public ScoreKeeperActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_score_keeper, container, false);
        initViews(rootView);
        initButtonListeners();
        displayScore(team1Score, team2Score);
        return rootView;
    }

    public void initViews(View view) {
        team1Score = 0;
        team1Score = 0;

        team1 = (TextView) view.findViewById(R.id.team1_textview);
        team2 = (TextView) view.findViewById(R.id.team2_textview);

        buttonAddTeam1 = (Button) view.findViewById(R.id.team1_add_button);
        buttonRemoveTeam1 = (Button) view.findViewById(R.id.team1_remove_button);
        buttonAddTeam2 = (Button) view.findViewById(R.id.team2_add_button);
        buttonRemoveTeam2 = (Button) view.findViewById(R.id.team2_remove_button);

        resetButton = (Button) view.findViewById(R.id.reset_button);
    }

    public void initButtonListeners() {
        buttonAddTeam1.setOnClickListener(mButtonListener);
        buttonRemoveTeam1.setOnClickListener(mButtonListener);
        buttonAddTeam2.setOnClickListener(mButtonListener);
        buttonRemoveTeam2.setOnClickListener(mButtonListener);
        resetButton.setOnClickListener(mButtonListener);
    }

    private View.OnClickListener mButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.team1_add_button:
                    addTeam1();
                    break;
                case R.id.team1_remove_button:
                    removeTeam1();
                    break;
                case R.id.team2_add_button:
                    addTeam2();
                    break;
                case R.id.team2_remove_button:
                    removeTeam2();
                    break;
                case R.id.reset_button:
                    reset();
                    break;
                default:
                    Toast.makeText(
                            view.getContext(),
                            view.getResources().getText(R.string.error),
                            Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void addTeam1() {
        team1Score++;
        displayScore(team1Score, team2Score);
    }

    private void removeTeam1() {
        if (team1Score > 0) {
            team1Score--;
            displayScore(team1Score, team2Score);
        }
    }

    private void addTeam2() {
        team2Score++;
        displayScore(team1Score, team2Score);
    }

    private void removeTeam2() {
        if (team2Score > 0) {
            team2Score--;
            displayScore(team1Score, team2Score);
        }
    }

    private void reset() {
        team1Score = 0;
        team2Score = 0;
        displayScore(team1Score, team2Score);
    }

    private void displayScore(int score1, int score2) {
        team1.setText(String.valueOf(score1));
        team2.setText(String.valueOf(score2));
    }
}
