export function getFormattedCurrentDateTime() {
  const date = new Date(Date.now());
  let month = date.getUTCMonth() + 1;
  let todayDate = date.getUTCDate();
  let currentHours = date.getUTCHours();
  let currentMinutes = date.getUTCMinutes();
  let currentSeconds = date.getUTCSeconds();

  if (month < 10) {
    month = `0${month}`;
  }
  if (todayDate < 10) {
    todayDate = `0${todayDate}`;
  }
  if (currentHours < 10) {
    currentHours = `0${currentHours}`;
  }
  if (currentMinutes < 10) {
    currentMinutes = `0${currentMinutes}`;
  }
  if (currentSeconds < 10) {
    currentSeconds = `0${currentSeconds}`;
  }
  const formattedDate =
  `${date.getFullYear()}-${month}-${todayDate} ${currentHours}:${currentMinutes}:${currentSeconds}`;
  return formattedDate;
}
