package com.example.lesson


import androidx.recyclerview.widget.RecyclerView
import com.example.lesson.entity.Lesson
import androidx.appcompat.app.AppCompatActivity
import com.example.core.BaseView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter?>,
    Toolbar.OnMenuItemClickListener {
    override val presenter = LessonPresenter(this)
    private val lessonAdapter = LessonAdapter()
    private var refreshLayout: SwipeRefreshLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = lessonAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        refreshLayout = findViewById(R.id.swipe_refresh_layout)
        refreshLayout?.setOnRefreshListener(OnRefreshListener { presenter.fetchData() })
        refreshLayout?.isRefreshing = true
        presenter.fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout!!.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        presenter.showPlayback()
        return false
    }
}