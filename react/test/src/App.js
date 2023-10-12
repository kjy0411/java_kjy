import {BrowserRouter, Routes, Route, Link, useLocation, useNavigate} from 'react-router-dom'
import {useState, useEffect} from 'react'
import './App.css';

function App() {
  let [list, setList] = useState([{
    id : 1,
    title : 'Movie 1',
    genre : 'Drama',
    release_date : '2022-01-01'
  },{
    id : 2,
    title : 'Movie 2',
    genre : 'Action',
    release_date : '2022-02-01'
  },{
    id : 3,
    title : 'Movie 3',
    genre : 'Comedy',
    release_date : '2022-03-01'
  }]);
  const deleteMovie = (id)=>{
    let tmpList = list.filter(item=>item.id != id);
    setList(tmpList);
  }
  const insertMovie = (Movie)=>{
    setList([...list, Movie])
  }
  return (
    <div>
      <BrowserRouter>
        <Header/>
        <Routes>
          <Route path="/" exact element={<Home list={list} deleteMovie={deleteMovie} insertMovie={insertMovie}/>} />
          <Route path='/Insert' element={<Insert list={list}/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

function Header() {
  return(
    <div className='menu'>
       <ul className='menu-list'>
        <li className='menu-item'>
          <Link to="/" className='menu-link'>List</Link>
        </li>
        <li className='menu-item'>
          <Link to='/Insert' className='menu-link'>Add New Movie</Link>
        </li>
      </ul>
    </div>
  )
}

function Home({list, deleteMovie, insertMovie}) {
  const location = useLocation();
	let Movie = location.state;
  useEffect(()=> {
    if(Movie != null){
          insertMovie(Movie);
          location.state = null;
    }
  });
	
  return(
    <div className='list-page'>
      <h1 className='page-title'>Movies</h1>
      <table className='list-table'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {list.length == 0 ?
						<tr><th colSpan={5}><h1>등록된 영화가 없습니다.</h1></th></tr> : 
						list.map(item=>{
							return(
								<tr key={item.id}>
									<td>{item.id}</td>
									<td>{item.title}</td>
									<td>{item.genre}</td>
									<td>{item.release_date}</td>
									<td><button onClick={()=>{deleteMovie(item.id)}}>Delete</button></td>
								</tr>
							)
						})
					}
        </tbody>
      </table>
    </div>
  )
}

function Insert({list}) {
  const navigate = useNavigate();
	const [id, setId] = useState('');
	const [title, setTitle] = useState('');
	const [genre, setGenre] = useState('');
	const [release_date, setrelease_date] = useState('');

	const idChange = e =>setId(e.target.value);
	const titleChange = e =>setTitle(e.target.value);
	const genreChange = e =>setGenre(e.target.value);
	const release_dateChange = e =>setrelease_date(e.target.value);

  const check = (id, title, genre, release_date)=>{
    let idCheck = list.filter(item=>item.id == id)
    if(idCheck.length != 0){
      alert("중복된 ID는 사용할 수 없습니다.")
      return false;
    }
    if(id == '' || title == '' || genre == '' || release_date == ''){
      alert("모든 항목을 입력해주세요.")
      return false;
    }
    return true;
  }
  const insertMovie = ()=>{
    if(check(id, title, genre, release_date)){
      navigate('/', {
        state : {
          id : id,
          title : title,
          genre : genre,
          release_date : release_date
        }
      })
    }
    clear();
  }
  const clear = ()=>{
    setId('')
    setTitle('')
    setGenre('')
    setrelease_date('')
  }

  return(
    <div className='insert'>
      <h1 className='page-title'>Create Movie</h1>
      <div className='insert-box'>
        <input type='number' placeholder='Input movie id' onChange={idChange} value={id} min={1}/>
        <br/>
        <input type='text' placeholder='Input movie title' onChange={titleChange} value={title}/>
        <br/>
        <input type='text' placeholder='Input movie genre' onChange={genreChange} value={genre}/>
        <br/>
        <span>출시일:</span>
        <input type='date' onChange={release_dateChange} value={release_date}/>
        <br/>
        <button onClick={insertMovie}>Add Movie</button>
      </div>
    </div>
  )
}

export default App;