package com.org.quiz.admin.adapters;

import static com.org.quiz.admin.models.AllQuizModel.VIEW_QUIZ_CATEGORY_NAME;
import static com.org.quiz.admin.models.AllQuizModel.VIEW_QUIZ_NAME;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.quiz.admin.models.AllQuizModel;
import com.org.quiz.R;

import java.util.List;

public class AllQuizAdapter extends RecyclerView.Adapter{
    List<AllQuizModel> quizModelList;
    Context context;

    public AllQuizAdapter(List<AllQuizModel> quizModelList, Context context) {
        this.quizModelList = quizModelList;
        this.context = context;
    }

    /*@Override
    public int getItemViewType(int position) {
        switch (quizModelList.get(position).getViewType()){
            case 0:
                return VIEW_QUIZ_CATEGORY_NAME;
            case 1:
                return VIEW_QUIZ_NAME;
            default:
                return -1;
        }
        //super.getItemViewType(position);
    }
*/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*switch (viewType) {
            case VIEW_QUIZ_CATEGORY_NAME:
                return new CategoryName(LayoutInflater.from(context).inflate(R.layout.item_category_name,parent, false));
            case VIEW_QUIZ_NAME :
                return new QuizItem(LayoutInflater.from(context).inflate(R.layout.item_quiz_topics,parent, false));

            default:
                return null;
        }*/
        return new QuizItem(LayoutInflater.from(context).inflate(R.layout.item_quiz_topics,parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (quizModelList != null)? quizModelList.size() : 0;
    }

    class CategoryName extends RecyclerView.ViewHolder {
         public CategoryName(@NonNull View itemView) {
             super(itemView);
         }
    }

    class QuizItem extends RecyclerView.ViewHolder {
        public QuizItem(@NonNull View itemView) {
            super(itemView);
        }
    }
}
