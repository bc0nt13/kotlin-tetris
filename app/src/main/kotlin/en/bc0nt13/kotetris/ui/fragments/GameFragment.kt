package en.bc0nt13.kotetris.ui.fragments

import android.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import en.bc0nt13.kotetris.R
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.ImageView
import java.util.ArrayList

class GameFragment : Fragment(){
    val cells : Array<Array<ImageView?>> = Array(10, {arrayOfNulls<ImageView>(20)})

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        val map  = rootView.findViewById(R.id.field_table) as TableLayout
        setMapAspectRatio(map)
        queryMapCells(map)
        return rootView
    }

    private fun setMapAspectRatio(map: TableLayout) {
        val width = map.getHeight() / 2
        map.setLayoutParams(ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    fun queryMapCells(map: TableLayout) {
        var x = 0
        var y = 0
         for(row in map){
             if (row is TableRow){
                 for (cell in row){
                     if (cell is ImageView){
                         cells[x][y] = cell;
                         x++
                     }
                 }
                 y++
             }
         }
    }
}

fun TableLayout.iterator() : ViewGroupIterator{
    return ViewGroupIterator(this)
}

fun TableRow.iterator(): ViewGroupIterator{
    return ViewGroupIterator(this)
}

class ViewGroupIterator(val table: ViewGroup) : Iterator<View> {
    
    var idx = 0;
    override fun hasNext(): Boolean {
        return idx < table.getChildCount()
    }

    override fun next(): View {
        var result = table.getChildAt(idx)
        idx++
        return result
    }

}
