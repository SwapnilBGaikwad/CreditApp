if [ -z "$PROJECT_ID" ]; then
  echo 1>&2 "$0: App ID is missing"
  exit 1
fi


docker build -t gcr.io/$PROJECT_ID/spend .
