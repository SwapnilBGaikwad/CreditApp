if [ -z "$1" ]; then
  echo 1>&2 "$0: not enough arguments"
  exit 1
fi

docker build -t gcr.io/upbeat-handler-263217/credit --build-arg APP_ENV=$1 .
