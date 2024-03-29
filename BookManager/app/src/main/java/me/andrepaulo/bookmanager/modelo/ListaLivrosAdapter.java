package me.andrepaulo.bookmanager.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import me.andrepaulo.bookmanager.R;

/**
 * Created by andre on 03/11/2017.
 */

public class ListaLivrosAdapter extends BaseAdapter{

    private ArrayList<Livro> listaLivros;
    private Context context;
    private LayoutInflater inflater;

    public ListaLivrosAdapter(Context contexto, ArrayList<Livro> livros) {
        this.listaLivros = livros;
        this.context = contexto;
        this.inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return listaLivros.size();
    }

    @Override
    public Livro getItem(int position) {
        return listaLivros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_lista_livro, null);
        }
        TextView tv_titulo = (TextView) convertView.findViewById(R.id.tv_titulo);
        TextView tv_serie = (TextView) convertView.findViewById(R.id.tv_serie);
        TextView tv_autor = (TextView) convertView.findViewById(R.id.tv_autor);
        TextView tv_ano = (TextView) convertView.findViewById(R.id.tv_ano);
        ImageView iv_capa = (ImageView) convertView.findViewById(R.id.iv_capa);

        tv_titulo.setText(listaLivros.get(position).getTitulo());
        tv_serie.setText(listaLivros.get(position).getSerie());
        tv_autor.setText(listaLivros.get(position).getAutor());
        tv_ano.setText(listaLivros.get(position).getAno() + "");
        Glide.with(context)
                .load(listaLivros.get(position).getCapa())
                .placeholder(R.drawable.ipl_semfundo)
                .thumbnail(0f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_capa);

        return convertView;
    }

    public void refresh(ArrayList<Livro> livros){
        this.listaLivros = livros;
        notifyDataSetChanged();
    }
}
