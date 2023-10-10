import {useState} from "react"

function Main() {
  let [page, setPage] = useState(1);
  const max = 13;
  const leftBtnClick = () =>{
    setPage(page == 1 ? max : page - 1)
  }
  const rightBtnClick = () =>{
    setPage(page == max ? 1 : page + 1)
  }
  return (
    <main>
      <div>
        <button onClick={leftBtnClick}>-</button>
        <span>{page} / {max}</span>
        <button onClick={rightBtnClick}>+</button>
      </div>
    </main>
  )
}
export default Main;