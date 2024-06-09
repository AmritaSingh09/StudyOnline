package com.org.course.ui;

import android.os.Bundle;
import android.text.Html;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.org.course.R;
import com.org.course.core.adapters.ExpandableCourseContentAdapter;
import com.org.course.core.adapters.StringListAdapter;
import com.org.course.core.models.CourseModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NewCourseDetailActivity extends AppCompatActivity {

    TextView title, short_description, auther_name, auther_expert, auther_desc, content_overview, long_desc, watch_demo, buy_now, includes;
    RecyclerView requirements, outcome, content, course_for;
    ImageView auther_pic, thumbnail, bookmark, play_vid;
    FrameLayout img_frame;
    VideoView intro_vid;
    CourseModel courseModel;
    String requirement_list, outcome_list, content_list, course_for_list;
    //List<String> requirement_list, outcome_list, content_list, course_for_list;

    ExpandableListView expandableListViewExample;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableTitleList;
    HashMap<String, List<String>> expandableDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_course_detail);
        initViews();

        StringListAdapter requirement_adapter = new StringListAdapter(getList(requirement_list), NewCourseDetailActivity.this);
        StringListAdapter outcome_adapter = new StringListAdapter(getList(outcome_list), NewCourseDetailActivity.this);
        StringListAdapter content_adapter = new StringListAdapter(getList(content_list), NewCourseDetailActivity.this);
        StringListAdapter course_for_adapter = new StringListAdapter(getList(course_for_list), NewCourseDetailActivity.this);

        requirements.setAdapter(requirement_adapter);
        outcome.setAdapter(outcome_adapter);
        content.setAdapter(content_adapter);
        course_for.setAdapter(course_for_adapter);
        long_desc.setText(Html.fromHtml(getDescr(), HtmlCompat.FROM_HTML_MODE_LEGACY));

        expandableListViewExample = (ExpandableListView) findViewById(R.id.expandableListViewSample);
        expandableDetailList = getData();
        expandableTitleList = new ArrayList<String>(expandableDetailList.keySet());
        expandableListAdapter = new ExpandableCourseContentAdapter(this, expandableTitleList, expandableDetailList);
        expandableListViewExample.setAdapter(expandableListAdapter);

        // This method is called when the group is expanded
        expandableListViewExample.setOnGroupExpandListener(groupPosition ->
                Toast.makeText(NewCourseDetailActivity.this, expandableTitleList.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show());

        // This method is called when the group is collapsed
        expandableListViewExample.setOnGroupCollapseListener(groupPosition ->
                Toast.makeText(NewCourseDetailActivity.this, expandableTitleList.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show());

        // This method is called when the child in any group is clicked
        // via a toast method, it is shown to display the selected child item as a sample
        // we may need to add further steps according to the requirements
        expandableListViewExample.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Toast.makeText(NewCourseDetailActivity.this, expandableTitleList.get(groupPosition)
                    + " -> "
                    + expandableDetailList.get(
                    expandableTitleList.get(groupPosition)).get(
                    childPosition), Toast.LENGTH_SHORT
            ).show();
            return false;
        });

    }

    private String getDescr() {
        return "*** As seen on Kickstarter ***\n" +
                "\\nArtificial intelligence is growing exponentially. There is no doubt about that. Self-driving cars are clocking up millions of miles, IBM Watson is diagnosing patients better than armies of doctors and Google Deepmind's AlphaGo beat the World champion at Go - a game where intuition plays a key role.\n" +
                "\n" +
                "\\nBut the further AI advances, the more complex become the problems it needs to solve. And only Deep Learning can solve such complex problems and that's why it's at the heart of Artificial intelligence.\n" +
                "\n" +
                "\\n--- Why Deep Learning A-Z? ---\n" +
                "\n" +
                "\\nHere are five reasons we think Deep Learning A-Z really is different, and stands out from the crowd of other training programs out there:\n" +
                "\n" +
                "\\n1. ROBUST STRUCTURE\n" +
                "\n" +
                "\\nThe first and most important thing we focused on is giving the course a robust structure. Deep Learning is very broad and complex and to navigate this maze you need a clear and global vision of it.\n" +
                "\n" +
                "That's why we grouped the tutorials into two volumes, representing the two fundamental branches of Deep Learning: Supervised Deep Learning and Unsupervised Deep Learning. With each volume focusing on three distinct algorithms, we found that this is the best structure for mastering Deep Learning.\n" +
                "\n" +
                "2. INTUITION TUTORIALS\n" +
                "\n" +
                "So many courses and books just bombard you with the theory, and math, and coding... But they forget to explain, perhaps, the most important part: why you are doing what you are doing. And that's how this course is so different. We focus on developing an intuitive *feel* for the concepts behind Deep Learning algorithms.\n" +
                "\n" +
                "With our intuition tutorials you will be confident that you understand all the techniques on an instinctive level. And once you proceed to the hands-on coding exercises you will see for yourself how much more meaningful your experience will be. This is a game-changer.\n" +
                "\n" +
                "3. EXCITING PROJECTS\n" +
                "\n" +
                "Are you tired of courses based on over-used, outdated data sets?\n" +
                "\n" +
                "Yes? Well then you're in for a treat.\n" +
                "\n" +
                "Inside this class we will work on Real-World datasets, to solve Real-World business problems. (Definitely not the boring iris or digit classification datasets that we see in every course). In this course we will solve six real-world challenges:\n" +
                "\n" +
                "Artificial Neural Networks to solve a Customer Churn problem\n" +
                "\n" +
                "Convolutional Neural Networks for Image Recognition\n" +
                "\n" +
                "Recurrent Neural Networks to predict Stock Prices\n" +
                "\n" +
                "Self-Organizing Maps to investigate Fraud\n" +
                "\n" +
                "Boltzmann Machines to create a Recomender System\n" +
                "\n" +
                "Stacked Autoencoders* to take on the challenge for the Netflix $1 Million prize\n" +
                "\n" +
                "*Stacked Autoencoders is a brand new technique in Deep Learning which didn't even exist a couple of years ago. We haven't seen this method explained anywhere else in sufficient depth.\n" +
                "\n" +
                "4. HANDS-ON CODING\n" +
                "\n" +
                "In Deep Learning A-Z we code together with you. Every practical tutorial starts with a blank page and we write up the code from scratch. This way you can follow along and understand exactly how the code comes together and what each line means.\n" +
                "\n" +
                "In addition, we will purposefully structure the code in such a way so that you can download it and apply it in your own projects. Moreover, we explain step-by-step where and how to modify the code to insert YOUR dataset, to tailor the algorithm to your needs, to get the output that you are after.\n" +
                "\n" +
                "This is a course which naturally extends into your career.\n" +
                "<br>5. IN-COURSE SUPPORT\n" +
                "\n" +
                "Have you ever taken a course or read a book where you have questions but cannot reach the author?\n" +
                "\n" +
                "Well, this course is different. We are fully committed to making this the most disruptive and powerful Deep Learning course on the planet. With that comes a responsibility to constantly be there when you need our help.\n" +
                "\n" +
                "In fact, since we physically also need to eat and sleep we have put together a team of professional Data Scientists to help us out. Whenever you ask a question you will get a response from us within 48 hours maximum.\n" +
                "\n" +
                "No matter how complex your query, we will be there. The bottom line is we want you to succeed.\n" +
                "\n" +
                "<b> The Tools </b>\n" +
                "\n" +
                "Tensorflow and Pytorch are the two most popular open-source libraries for Deep Learning. In this course you will learn both!\n" +
                "\n" +
                "TensorFlow was developed by Google and is used in their speech recognition system, in the new google photos product, gmail, google search and much more. Companies using Tensorflow include AirBnb, Airbus, Ebay, Intel, Uber and dozens more.\n" +
                "\n" +
                "PyTorch is as just as powerful and is being developed by researchers at Nvidia and leading universities: Stanford, Oxford, ParisTech. Companies using PyTorch include Twitter, Saleforce and Facebook.\n" +
                "\n" +
                "So which is better and for what?\n" +
                "\n" +
                "Well, in this course you will have an opportunity to work with both and understand when Tensorflow is better and when PyTorch is the way to go. Throughout the tutorials we compare the two and give you tips and ideas on which could work best in certain circumstances.\n" +
                "\n" +
                "The interesting thing is that both these libraries are barely over 1 year old. That's what we mean when we say that in this course we teach you the most cutting edge Deep Learning models and techniques.\n" +
                "\n" +
                "<br><b> More Tools </b>\n" +
                "\n" +
                "\\nTheano is another open source deep learning library. It's very similar to Tensorflow in its functionality, but nevertheless we will still cover it.\n" +
                "\n" +
                "\\nKeras is an incredible library to implement Deep Learning models. It acts as a wrapper for Theano and Tensorflow. Thanks to Keras we can create powerful and complex Deep Learning models with only a few lines of code. This is what will allow you to have a global vision of what you are creating. Everything you make will look so clear and structured thanks to this library, that you will really get the intuition and understanding of what you are doing.\n" +
                "\n" +
                "\\n<b> Even More Tools </b>\n" +
                "\n" +
                "\\nScikit-learn the most practical Machine Learning library. We will mainly use it:\n" +
                "\n" +
                "to evaluate the performance of our models with the most relevant technique, k-Fold Cross Validation\n" +
                "\n" +
                "to improve our models with effective Parameter Tuning\n" +
                "\n" +
                "to preprocess our data, so that our models can learn in the best conditions\n" +
                "\n" +
                "\\nAnd of course, we have to mention the usual suspects. This whole course is based on Python and in every single section you will be getting hours and hours of invaluable hands-on practical coding experience.\n" +
                "\n" +
                "\\nPlus, throughout the course we will be using Numpy to do high computations and manipulate high dimensional arrays, Matplotlib to plot insightful charts and Pandas to import and manipulate datasets the most efficiently.\n" +
                "\n" +
                "\\n<b> Who Is This Course For? </b>\n" +
                "\n" +
                "\\nAs you can see, there are lots of different tools in the space of Deep Learning and in this course we make sure to show you the most important and most progressive ones so that when you're done with Deep Learning A-Z your skills are on the cutting edge of today's technology.\n" +
                "\n" +
                "\\nIf you are just starting out into Deep Learning, then you will find this course extremely useful. Deep Learning A-Z is structured around special coding blueprint approaches meaning that you won't get bogged down in unnecessary programming or mathematical complexities and instead you will be applying Deep Learning techniques from very early on in the course. You will build your knowledge from the ground up and you will see how with every tutorial you are getting more and more confident.\n" +
                "\n" +
                "\\nIf you already have experience with Deep Learning, you will find this course refreshing, inspiring and very practical. Inside Deep Learning A-Z you will master some of the most cutting-edge Deep Learning algorithms and techniques (some of which didn't even exist a year ago) and through this course you will gain an immense amount of valuable hands-on experience with real-world business challenges. Plus, inside you will find inspiration to explore new Deep Learning skills and applications.\n" +
                "\n" +
                "\\n<b> Real-World Case Studies </b>\n" +
                "\n" +
                "\\nMastering Deep Learning is not just about knowing the intuition and tools, it's also about being able to apply these models to real-world scenarios and derive actual measurable results for the business or project. That's why in this course we are introducing six exciting challenges:\n" +
                "\n" +
                "\\n#1 Churn Modelling Problem\n" +
                "\n" +
                "\\nIn this part you will be solving a data analytics challenge for a bank. You will be given a dataset with a large sample of the bank's customers. To make this dataset, the bank gathered information such as customer id, credit score, gender, age, tenure, balance, if the customer is active, has a credit card, etc. During a period of 6 months, the bank observed if these customers left or stayed in the bank.\n" +
                "\n" +
                "\\nYour goal is to make an Artificial Neural Network that can predict, based on geo-demographical and transactional information given above, if any individual customer will leave the bank or stay (customer churn). Besides, you are asked to rank all the customers of the bank, based on their probability of leaving. To do that, you will need to use the right Deep Learning model, one that is based on a probabilistic approach.\n" +
                "\n" +
                "\\nIf you succeed in this project, you will create significant added value to the bank. By applying your Deep Learning model the bank may significantly reduce customer churn.\n" +
                "\n" +
                "\\n#2 Image Recognition\n" +
                "\n" +
                "\\nIn this part, you will create a Convolutional Neural Network that is able to detect various objects in images. We will implement this Deep Learning model to recognize a cat or a dog in a set of pictures. However, this model can be reused to detect anything else and we will show you how to do it - by simply changing the pictures in the input folder.\n" +
                "\n" +
                "\\nFor example, you will be able to train the same model on a set of brain images, to detect if they contain a tumor or not. But if you want to keep it fitted to cats and dogs, then you will literally be able to a take a picture of your cat or your dog, and your model will predict which pet you have. We even tested it out on Hadelin’s dog!\n" +
                "\n" +
                "\\n#3 Stock Price Prediction\n" +
                "\n" +
                "\\nIn this part, you will create one of the most powerful Deep Learning models. We will even go as far as saying that you will create the Deep Learning model closest to “Artificial Intelligence”. Why is that? Because this model will have long-term memory, just like us, humans.\n" +
                "\n" +
                "\\nThe branch of Deep Learning which facilitates this is Recurrent Neural Networks. Classic RNNs have short memory, and were neither popular nor powerful for this exact reason. But a recent major improvement in Recurrent Neural Networks gave rise to the popularity of LSTMs (Long Short Term Memory RNNs) which has completely changed the playing field. We are extremely excited to include these cutting-edge deep learning methods in our course!\n" +
                "\n" +
                "\\nIn this part you will learn how to implement this ultra-powerful model, and we will take the challenge to use it to predict the real Google stock price. A similar challenge has already been faced by researchers at Stanford University and we will aim to do at least as good as them.\n" +
                "\n" +
                "\\n #4 Fraud Detection\n" +
                "\n" +
                "\\nAccording to a recent report published by Markets and Markets the Fraud Detection and Prevention Market is going to be worth $33.19 Billion USD by 2021. This is a huge industry and the demand for advanced Deep Learning skills is only going to grow. That’s why we have included this case study in the course.\n" +
                "\n" +
                "\\nThis is the first part of Volume 2 - Unsupervised Deep Learning Models. The business challenge here is about detecting fraud in credit card applications. You will be creating a Deep Learning model for a bank and you are given a dataset that contains information on customers applying for an advanced credit card.\n" +
                "\n" +
                "\\nThis is the data that customers provided when filling the application form. Your task is to detect potential fraud within these applications. That means that by the end of the challenge, you will literally come up with an explicit list of customers who potentially cheated on their applications.\n" +
                "\n" +
                "<br>#5 and 6 Recommender Systems\n" +
                "\n" +
                "\\nFrom Amazon product suggestions to Netflix movie recommendations - good recommender systems are very valuable in today's World. And specialists who can create them are some of the top-paid Data Scientists on the planet.\n" +
                "\n" +
                "\\nWe will work on a dataset that has exactly the same features as the Netflix dataset: plenty of movies, thousands of users, who have rated the movies they watched. The ratings go from 1 to 5, exactly like in the Netflix dataset, which makes the Recommender System more complex to build than if the ratings were simply “Liked” or “Not Liked”.\n" +
                "\n" +
                "\\nYour final Recommender System will be able to predict the ratings of the movies the customers didn’t watch. Accordingly, by ranking the predictions from 5 down to 1, your Deep Learning model will be able to recommend which movies each user should watch. Creating such a powerful Recommender System is quite a challenge so we will give ourselves two shots. Meaning we will build it with two different Deep Learning models.\n" +
                "\n" +
                "\\nOur first model will be Deep Belief Networks, complex Boltzmann Machines that will be covered in Part 5. Then our second model will be with the powerful AutoEncoders, my personal favorites. You will appreciate the contrast between their simplicity, and what they are capable of.\n" +
                "\n" +
                "<br>And you will even be able to apply it to yourself or your friends. The list of movies will be explicit so you will simply need to rate the movies you already watched, input your ratings in the dataset, execute your model and voila! The Recommender System will tell you exactly which movies you would love one night you if are out of ideas of what to watch on Netflix!\n" +
                "\n" +
                "<br><b> Summary </b>\n" +
                "<br>" +
                "<br>In conclusion, this is an exciting training program filled with intuition tutorials, practical exercises and real-World case studies.\n" +
                "<br>" +
                "<br>We are super enthusiastic about Deep Learning and hope to see you inside the class!\n" +
                "<br>" +
                "<br>Kirill and Hadelin ";
    }

    HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        // As we are populating List of fruits, vegetables and nuts, using them here
        // We can modify them as per our choice.
        // And also choice of fruits/vegetables/nuts can be changed
        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Guava");
        fruits.add("Papaya");
        fruits.add("Pineapple");

        List<String> vegetables = new ArrayList<String>();
        vegetables.add("Tomato");
        vegetables.add("Potato");
        vegetables.add("Carrot");
        vegetables.add("Cabbage");
        vegetables.add("Cauliflower");

        List<String> nuts = new ArrayList<String>();
        nuts.add("Cashews");
        nuts.add("Badam");
        nuts.add("Pista");
        nuts.add("Raisin");
        nuts.add("Walnut");

        // Fruits are grouped under Fruits Items. Similarly the rest two are under
        // Vegetable Items and Nuts Items respectively.
        // i.e. expandableDetailList object is used to map the group header strings to
        // their respective children using an ArrayList of Strings.
        expandableDetailList.put("Fruits Items", fruits);
        expandableDetailList.put("Vegetable Items", vegetables);
        expandableDetailList.put("Nuts Items", nuts);
        return expandableDetailList;
    }
    private List<String> getList(String requirementList) {
        List<String> stringList = Arrays.asList(requirementList.split("•"));
        return stringList;
    }

    private synchronized void initViews() {
        title = findViewById(R.id.new_c_title);
        short_description = findViewById(R.id.new_c_short_description);
        auther_pic = findViewById(R.id.new_c_auther_img);
        auther_name = findViewById(R.id.new_c_auther_name);
        auther_expert = findViewById(R.id.new_c_auther_expert);
        auther_desc = findViewById(R.id.new_c_auther_short_desc);
        requirements = findViewById(R.id.new_c_rv_requirement);
        outcome = findViewById(R.id.new_c_rv_outcome);
        content_overview = findViewById(R.id.new_c_course_content_overview);
        content = findViewById(R.id.new_c_rv_contents);
        long_desc = findViewById(R.id.new_c_long_desc);
        course_for = findViewById(R.id.new_c_rv_course_for);
        watch_demo = findViewById(R.id.new_c_watch_demo);
        buy_now = findViewById(R.id.new_c_buy_now);
        thumbnail = findViewById(R.id.new_c_thumbnail);
        bookmark = findViewById(R.id.new_c_bookmark);
        intro_vid = findViewById(R.id.new_c_intro_vid);
        play_vid = findViewById(R.id.new_c_play_vid);
        img_frame = findViewById(R.id.new_c_img_frame);
        includes = findViewById(R.id.new_c_includes);

        if (getIntent().getSerializableExtra("courseDataModel") != null){
            courseModel = (CourseModel) getIntent().getSerializableExtra("courseDataModel");
        }else finish();

        title.setText(courseModel.getName());
        short_description.setText(courseModel.getDesc());
        auther_name.setText(courseModel.getAuthor());
        short_description.setText(courseModel.getDesc());
        short_description.setText(courseModel.getDesc());

        requirement_list = "High school mathematics level. •A Basic Python programming knowledge.";
        outcome_list = "Understand the intuition behind Artificial Neural Networks" +
                "  • Apply Artificial Neural Networks in practice" +
                "  • Understand the intuition behind Convolutional Neural Networks" +
                "  • Apply Convolutional Neural Networks in practice" +
                "  • Understand the intuition behind Recurrent Neural Networks" +
                "  • Apply Recurrent Neural Networks in practice" +
                "  • Understand the intuition behind Self-Organizing Maps" +
                "  • Apply Self-Organizing Maps in practice" +
                "  • Understand the intuition behind Boltzmann Machines" +
                "  • Apply Boltzmann Machines in practice" +
                "  • Understand the intuition behind AutoEncoders" +
                "  • Apply AutoEncoders in practice";

        course_for_list = "Anyone interested in Deep Learning" +
                "•Students who have at least high school knowledge in math and who want to start learning Deep Learning" +
                "•Any intermediate level people who know the basics of Machine Learning or Deep Learning, including the classical algorithms like linear regression or logistic regression and more advanced topics like Artificial Neural Networks, but who want to learn more about it and explore all the different fields of Deep Learning" +
                "•Anyone who is not that comfortable with coding but who is interested in Deep Learning and wants to apply it easily on datasets" +
                "•Any students in college who want to start a career in Data Science" +
                "•Any data analysts who want to level up in Deep Learning" +
                "•Any people who are not satisfied with their job and who want to become a Data Scientist" +
                "•Any people who want to create added value to their business by using powerful Deep Learning tools" +
                "•Any business owners who want to understand how to leverage the Exponential technology of Deep Learning in their business" +
                "•Any Entrepreneur who wants to create disruption in an industry using the most cutting edge Deep Learning algorithms";

        content_list = "Welcome Challenge!    02:07" +
                "•Get the Datasets here   00:05" +
                "•EXTRA: Use ChatGPT to Boost your Deep Learning Skills 00:24" +
                "•Welcome to Part 1 - Artificial Neural Networks    00:07" +
                "•What You'll Need for ANN    00:07" +
                "•Plan of Attack    02:51" +
                "•The Neuron    16:15" +
                "•The Activation Function    08:29" +
                "•How do Neural Networks learn?    12:58" +
                "•Gradient Descent    10:12" +
                "•Stochastic Gradient Descent    08:44" +
                "•Backpropagation    05:21" +
                "•Business Problem Description    04:59" +
                "•IMPORTANT NOTE    00:59" +
                "•Building an ANN - Step 1    10:21" +
                "•Check out our free course on ANN for Regression    00:11" +
                "•Building an ANN - Step 2    18:36" +
                "•Building an ANN - Step 3    14:28" +
                "•Building an ANN - Step 4    11:58" +
                "•Building an ANN - Step 5    16:25" +
                "•Welcome to Part 2 - Convolutional Neural Networks    00:07" +
                "•What You'll Need for CNN    00:07" +
                "•Plan of attack    03:31" +
                "•Logistic Regression in Python - Step 1a    05:43" +
                "•Logistic Regression in Python - Step 1b    03:59" +
                "•Logistic Regression in Python - Step 2a    05:51" +
                "•Logistic Regression in Python - Step 2b    05:57" +
                "•Logistic Regression in Python - Step 3a    03:58" +
                "•Logistic Regression in Python - Step 3b    03:30" +
                "•Logistic Regression in Python - Step 4a    05:59" +
                "•Logistic Regression in Python - Step 4b    01:49" +
                "•Logistic Regression in Python - Step 5     05:59" +
                "•Logistic Regression in Python - Step 6a    05:52" +
                "•Logistic Regression in Python - Step 6b    03:33" +
                "•Logistic Regression in Python - Step 7a    05:54" +
                "•Logistic Regression in Python - Step 7b    03:44" +
                "•Logistic Regression in Python - Step 7c    03:19" +
                "•Logistic Regression in Python - Step 7 (Colour-blind friendly image)   00:12" +
                "•Machine Learning Regression and Classification EXTRA   00:19" +
                "•EXTRA CONTENT: Logistic Regression Practical Case Study    00:16" +
                "•Huge Congrats for completing the challenge!    01:33" +
                "•Bonus: How To UNLOCK Top Salaries (Live Training)  00:44";

    }


}