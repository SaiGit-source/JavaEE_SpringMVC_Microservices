import react from 'react';
// copied from https://materializecss.com/cards.html
export default function SingleContact(props){
    return(
  <div class="row">
    <div class="col s12 m6">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text">
          <span class="card-title">{props.contact.firstName} {props.contact.lastName}</span>
          <p>{props.contact.email}</p>
          <p>{props.contact.phone}</p>
        </div>
        <div class="card-action">
          <a href="#">This is a link</a>
          <a href="#">This is a link</a>
        </div>
      </div>
    </div>
  </div>    
  )
}
